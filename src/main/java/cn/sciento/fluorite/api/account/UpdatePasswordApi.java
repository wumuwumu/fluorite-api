package cn.sciento.fluorite.api.account;

import cn.sciento.fluorite.api.AbstractAPI;
import cn.sciento.fluorite.constants.ServerConstant;
import cn.sciento.fluorite.http.HttpPostMethod;
import cn.sciento.fluorite.response.BaseDeviceResponse;
import cn.sciento.fluorite.response.BasicResponse;
import cn.sciento.fluorite.response.account.AccountInfoResponse;
import cn.sciento.fluorite.utils.HttpUtil;
import cn.sciento.fluorite.utils.PasswordUtil;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class UpdatePasswordApi extends AbstractAPI {

    private String accountId;
    private String oldPassword;
    private String newPassword;
    private HttpPostMethod httpMethod;//请求方式


    public UpdatePasswordApi(String accessToken,String accountId, String  oldPassword, String  newPassword) {
        this.url = ServerConstant.GET_ACCOUNT_LIST;
        this.accessToken = accessToken;
        this.accountId = accountId;
        this.oldPassword = PasswordUtil.generate(oldPassword);
        this.newPassword = PasswordUtil.generate(newPassword);
        HttpUtil httpUtil = new HttpUtil();
        Map<String,Object> headMap = httpUtil.setHeadMap(host,contentType);
        httpMethod = new HttpPostMethod(method);
        httpMethod.setHeader(headMap);

        Map<String,Object> bodyMap = httpUtil.setBodyMap(accessToken,null,null);
        bodyMap.put("accountId",this.accountId);
        bodyMap.put("oldPassword",this.oldPassword);
        bodyMap.put("newPassword",this.newPassword);
        httpMethod.setCompleteUrl(url,bodyMap);
    }

    public BasicResponse<BaseDeviceResponse> executeApi() {
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
