package cn.sciento.fluorite.api.device.manage;

import cn.sciento.fluorite.api.AbstractAPI;
import cn.sciento.fluorite.constants.ServerConstant;
import cn.sciento.fluorite.http.HttpPostMethod;
import cn.sciento.fluorite.response.BaseDeviceResponse;
import cn.sciento.fluorite.response.BasicResponse;
import cn.sciento.fluorite.utils.HttpUtil;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.Map;

/**
 * @author wumu
 * @version V1.0
 * @date 4/18/18
 * @time 11:37 AM
 */
public class AddDeviceApi extends AbstractAPI{
    //private String accessToken;//授权过程获取的access_token
    private String deviceSerial;//设备的序列号
    private String validateCode;//设备验证码，设备机身上的六位大写字母
    private HttpPostMethod httpMethod;//请求方式


    public AddDeviceApi ( String accessToken, String deviceSerial,String validateCode) {
        this.url = ServerConstant.ADD_DEVICE;
        this.accessToken = accessToken;
        this.deviceSerial = deviceSerial;
        this.validateCode = validateCode;

        HttpUtil httpUtil = new HttpUtil();
        Map<String,Object> headMap = httpUtil.setHeadMap(host,contentType);
        httpMethod = new HttpPostMethod(method);
        httpMethod.setHeader(headMap);

        Map<String,Object> bodyMap = httpUtil.setBodyMap(accessToken,deviceSerial,validateCode);
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
