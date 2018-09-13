package cn.sciento.fluorite.api.weblive;

import cn.sciento.fluorite.api.AbstractAPI;
import cn.sciento.fluorite.constants.ServerConstant;
import cn.sciento.fluorite.http.HttpPostMethod;
import cn.sciento.fluorite.response.BasicResponse;
import cn.sciento.fluorite.response.OpenLiveResponse;
import cn.sciento.fluorite.response.WebLiveAddress;
import cn.sciento.fluorite.utils.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wumu
 * @version V1.0
 * @date 5/21/18
 * @time 4:26 PM
 */
public class OpenLive extends AbstractAPI {

    private String source;
    private HttpPostMethod httpPostMethod;

    public OpenLive(String accessToken,String source){
        this.accessToken = accessToken;
        this.source = source;
        this.url = ServerConstant.WEB_LIVE_OPEN_LIVE;

        HttpUtil httpUtil = new HttpUtil();
        Map<String,Object> headMap = httpUtil.setHeadMap(host,contentType);
        httpPostMethod = new HttpPostMethod(method);
        httpPostMethod.setHeader(headMap);

        Map<String,Object> bodyMap = httpUtil.setBodyMap(accessToken,null,null);
        bodyMap.put("source",source);

        httpPostMethod.setCompleteUrl(url,bodyMap);
    }

    public BasicResponse<List<OpenLiveResponse>> executeApi() {
        BasicResponse response = null;
        HttpResponse httpResponse = httpPostMethod.execute();

        try {
            response = JSON.parseObject(httpResponse.getEntity().getContent(), BasicResponse.class);
            response.setJson(JSON.toJSONString(response));

            // 将json对象转化成DeviceList对象数组ArrayList(DeviceListResponse)
            Object bs = response.getDataInternal();
            String stringJson = JSON.toJSONString(bs);
            List<OpenLiveResponse> openLiveResponses = JSON.parseObject(stringJson,new TypeReference<ArrayList<OpenLiveResponse>>(){});
            response.setData(openLiveResponses);
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
