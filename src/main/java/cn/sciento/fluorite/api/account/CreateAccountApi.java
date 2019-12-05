package cn.sciento.fluorite.api.account;

import cn.sciento.fluorite.api.AbstractAPI;
import cn.sciento.fluorite.constants.ServerConstant;
import cn.sciento.fluorite.http.HttpPostMethod;
import cn.sciento.fluorite.response.BaseDeviceResponse;
import cn.sciento.fluorite.response.BasicResponse;
import cn.sciento.fluorite.response.account.CreateAccountResponse;
import cn.sciento.fluorite.utils.HttpUtil;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.Map;

public class CreateAccountApi extends AbstractAPI {


    private String accountName;//设备的序列号
    private String password;//设备验证码，设备机身上的六位大写字母
    private HttpPostMethod httpMethod;//请求方式


    public CreateAccountApi ( String accessToken, String accountName,String password) {
        this.url = ServerConstant.ADD_DEVICE;
        this.accessToken = accessToken;
        this.accountName = accountName;
        this.password = password;

        HttpUtil httpUtil = new HttpUtil();
        Map<String,Object> headMap = httpUtil.setHeadMap(host,contentType);
        httpMethod = new HttpPostMethod(method);
        httpMethod.setHeader(headMap);

        Map<String,Object> bodyMap = httpUtil.setBodyMap(accessToken,accountName,password);
        httpMethod.setCompleteUrl(url,bodyMap);
    }

    public BasicResponse<CreateAccountResponse> executeApi() {
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
