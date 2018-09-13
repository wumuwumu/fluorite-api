package cn.sciento.fluorite.api.device.manage;

import cn.sciento.fluorite.api.AbstractAPI;
import cn.sciento.fluorite.constants.ServerConstant;
import cn.sciento.fluorite.http.HttpPostMethod;
import cn.sciento.fluorite.request.RequestInfo;
import cn.sciento.fluorite.response.BasicResponse;
import cn.sciento.fluorite.response.CapturePicture;
import cn.sciento.fluorite.utils.HttpUtil;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.Map;

/**
 * @author wumu
 * @version V1.0
 * @date 4/18/18
 * @time 12:23 PM
 */
public class CapturePicApi extends AbstractAPI{
    private String deviceSerial;
    private int channelNo;
    private HttpPostMethod httpPostMethod;

    public CapturePicApi( String accessToken, String deviceSerial) {
        this.url = ServerConstant.CAPTURE_PICTURE;
        this.accessToken = accessToken;
        this.deviceSerial = deviceSerial;
        this.channelNo = 1;
        this.method = RequestInfo.Method.POST;
        this.host = ServerConstant.HOST;
        this.contentType = "application/x-www-form-urlencoded";

        //设置http的head
        HttpUtil httpUtil = new HttpUtil();
        Map<String,Object> headMap = httpUtil.setHeadMap(host,contentType);
        httpPostMethod = new HttpPostMethod(method);
        httpPostMethod.setHeader(headMap);

        //设置http的
        Map<String,Object> bodyMap = httpUtil.setBodyMap(accessToken,deviceSerial,null);
        if (channelNo == 1) {
            bodyMap.put("channelNo",1);
        }
        httpPostMethod.setCompleteUrl(url,bodyMap);
    }

    public BasicResponse<CapturePicture> executeApi() {
        BasicResponse response = null;
        HttpResponse httpResponse = httpPostMethod.execute();

        try {
            response = JSON.parseObject(httpResponse.getEntity().getContent(), BasicResponse.class);
            response.setJson(JSON.toJSONString(response));
            Object data = JSON.parseObject(JSON.toJSONString(response.getDataInternal()), CapturePicture.class);
            response.setData(data);
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
