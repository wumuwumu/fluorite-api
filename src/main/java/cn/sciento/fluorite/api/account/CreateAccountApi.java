package cn.sciento.fluorite.api.account;

import cn.sciento.fluorite.api.AbstractAPI;
import cn.sciento.fluorite.constants.ServerConstant;
import cn.sciento.fluorite.http.HttpPostMethod;
import cn.sciento.fluorite.response.BaseDeviceResponse;
import cn.sciento.fluorite.response.BasicResponse;
import cn.sciento.fluorite.response.account.AccountInfoResponse;
import cn.sciento.fluorite.response.account.CreateAccountResponse;
import cn.sciento.fluorite.utils.HttpUtil;
import cn.sciento.fluorite.utils.MD5Util;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.Map;

public class CreateAccountApi extends AbstractAPI {


    private String accountName;//账号名称
    private String password;//账号密码
    private HttpPostMethod httpMethod;//请求方式


    public CreateAccountApi ( String accessToken, String accountName,String password) {
        this.url = ServerConstant.CREATE_ACCOUNT;
        this.accessToken = accessToken;
        this.accountName = accountName;
        String mdPassword = MD5Util.code("AppKey#"+password);
        if(mdPassword == null){
            throw new NullPointerException("密码加密失败");
        }
        this.password = mdPassword.toLowerCase();
        HttpUtil httpUtil = new HttpUtil();
        Map<String,Object> headMap = httpUtil.setHeadMap(host,contentType);
        httpMethod = new HttpPostMethod(method);
        httpMethod.setHeader(headMap);

        Map<String,Object> bodyMap = httpUtil.setBodyMap(accessToken,null,null);
        bodyMap.put("accountName",this.accountName);
        bodyMap.put("password",this.password);
        httpMethod.setCompleteUrl(url,bodyMap);
    }

    public BasicResponse<AccountInfoResponse> executeApi() {
        BasicResponse response = null;
        HttpResponse httpResponse = httpMethod.execute();

        try {
            response = JSON.parseObject(httpResponse.getEntity().getContent(),BasicResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            httpMethod.httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }


}
