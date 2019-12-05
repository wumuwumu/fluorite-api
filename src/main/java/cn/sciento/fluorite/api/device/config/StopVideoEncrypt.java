package cn.sciento.fluorite.api.device.config;


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
 * @date 5/18/18
 * @time 4:52 PM
 */
public class StopVideoEncrypt extends AbstractAPI {

    private String validateCode;
    private String deviceSerial;

    private HttpPostMethod httpPostMethod;//请求方式

    public StopVideoEncrypt(String accessToken, String deviceSerial,String validateCode){
        this.accessToken = accessToken;
        this.deviceSerial = deviceSerial;
        this.validateCode = validateCode;
        this.url = ServerConstant.STOP_VIDEO_ENCRYPT;

        //设置http的head
        HttpUtil httpUtil = new HttpUtil();
        Map<String,Object> headMap = httpUtil.setHeadMap(host,contentType);
        httpPostMethod = new HttpPostMethod(method);
        httpPostMethod.setHeader(headMap);

        //设置http的body
        Map<String,Object> bodyMap = httpUtil.setBodyMap(accessToken,deviceSerial,validateCode);

        httpPostMethod.setCompleteUrl(url,bodyMap);

    }

    public BasicResponse<BaseDeviceResponse> executeApi(){
        BasicResponse response = null;
        HttpResponse httpResponse = httpPostMethod.execute();

        try {
            response = JSON.parseObject(httpResponse.getEntity().getContent(), BasicResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            httpPostMethod.httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

}
