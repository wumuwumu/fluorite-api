package cn.sciento.fluorite.api.weblive;

import cn.sciento.fluorite.api.AbstractAPI;
import cn.sciento.fluorite.constants.ServerConstant;
import cn.sciento.fluorite.http.HttpPostMethod;
import cn.sciento.fluorite.request.RequestInfo;
import cn.sciento.fluorite.response.BasicResponse;
import cn.sciento.fluorite.response.WebLiveAddress;
import cn.sciento.fluorite.utils.HttpUtil;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.Map;

/**
 * @author wumu
 * @version V1.0
 * @date 5/6/18
 * @time 9:15 PM
 */
public class GetPeriodAddress extends AbstractAPI {

    private String deviceSerial;
    private int channelNo = 1;
    // 单位：秒，最小为300，单位秒数，最大默认62208000（即720天），最小默认300（即5分钟）
    private int expireTime = 300;

    private HttpPostMethod httpPostMethod;

    public GetPeriodAddress(String accessToken,String  deviceSerial,int expireTime) {
        this.deviceSerial = deviceSerial;
        this.expireTime = expireTime;
        this.url = ServerConstant.WEB_LIVE_PERIOD_ADDRESS;
        this.method = RequestInfo.Method.POST;
        this.host = ServerConstant.HOST;
        this.contentType = "application/x-www-form-urlencoded";


        //设置http的head
        HttpUtil httpUtil = new HttpUtil();
        Map<String,Object> headMap = httpUtil.setHeadMap(host,contentType);
        httpPostMethod = new HttpPostMethod(method);
        httpPostMethod.setHeader(headMap);

        //设置http的body
        Map<String,Object> bodyMap = httpUtil.setBodyMap(accessToken,deviceSerial,null);
        if(this.expireTime > 300){
            bodyMap.put("expireTime",expireTime);
        }
        bodyMap.put("channelNo",channelNo);

        httpPostMethod.setCompleteUrl(url,bodyMap);
    }

    public BasicResponse<WebLiveAddress> executeApi() {
        BasicResponse response = null;
        HttpResponse httpResponse = httpPostMethod.execute();

        try {
            response = JSON.parseObject(httpResponse.getEntity().getContent(), BasicResponse.class);
            response.setJson(JSON.toJSONString(response));

            // 将json对象转化成DeviceList对象数组ArrayList(DeviceListResponse)
            Object bs = response.getDataInternal();
            String stringJson = JSON.toJSONString(bs);
            WebLiveAddress webLiveAddress = JSON.parseObject(stringJson,WebLiveAddress.class);
            response.setData(webLiveAddress);
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
