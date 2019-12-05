package cn.sciento.fluorite.api.weblive;

import cn.sciento.fluorite.api.AbstractAPI;
import cn.sciento.fluorite.constants.ServerConstant;
import cn.sciento.fluorite.http.HttpPostMethod;
import cn.sciento.fluorite.request.RequestInfo;
import cn.sciento.fluorite.response.BasicResponse;
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
 * @date 5/17/18
 * @time 4:26 PM
 */
public class GetAddressList extends AbstractAPI {

    private String deviceSerial;

    private int pageStart = 0;

    private int pageSize = 10;

    private HttpPostMethod httpPostMethod;

    public GetAddressList(String accessToken){
        this(accessToken,0,10);
    }

    public GetAddressList(String accessToken, int pageStart, int pageSize) {
        this.pageSize = pageSize;
        this.pageStart = pageStart;
        this.url = ServerConstant.WEB_LIVE_ADDRESS_LIST;
        this.method = RequestInfo.Method.POST;
        this.host = ServerConstant.HOST;
        this.contentType = "application/x-www-form-urlencoded";


        //设置http的head
        HttpUtil httpUtil = new HttpUtil();
        Map<String,Object> headMap = httpUtil.setHeadMap(host,contentType);
        httpPostMethod = new HttpPostMethod(method);
        httpPostMethod.setHeader(headMap);

        //设置http的body
        Map<String,Object> bodyMap = httpUtil.setBodyMap(accessToken,null,null);
        bodyMap.put("pageStart",pageStart);
        bodyMap.put("pageSize",pageSize);

        httpPostMethod.setCompleteUrl(url,bodyMap);
    }

    public BasicResponse<List<WebLiveAddress>> executeApi() {
        BasicResponse response = null;
        HttpResponse httpResponse = httpPostMethod.execute();

        try {
            response = JSON.parseObject(httpResponse.getEntity().getContent(), BasicResponse.class);
            response.setJson(JSON.toJSONString(response));

            // 将json对象转化成DeviceList对象数组ArrayList(DeviceListResponse)
            Object bs = response.getDataInternal();
            String stringJson = JSON.toJSONString(bs);
            List<WebLiveAddress> webLiveAddressList = JSON.parseObject(stringJson, new TypeReference<ArrayList<WebLiveAddress>>(){});
            response.setData(webLiveAddressList);
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
