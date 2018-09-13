package cn.sciento.fluorite.api.token;


import cn.sciento.fluorite.api.AbstractAPI;
import cn.sciento.fluorite.constants.ServerConstant;
import cn.sciento.fluorite.http.HttpPostMethod;
import cn.sciento.fluorite.request.RequestInfo;
import cn.sciento.fluorite.response.AccessToken;
import cn.sciento.fluorite.response.BasicResponse;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wumu
 * @version V1.0
 * @date 4/18/18
 * @time 11:01 AM
 */
public class GetToken extends AbstractAPI {

    //private String url = "https://open.ys7.com/api/lapp/token/get";
    private String appKey;
    private String appSecret;
    //private String host;
    //private String Content_Type;
    private HttpPostMethod httpPostMethod;

    public GetToken(String appKey,String appSecret) {
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.url = ServerConstant.GET_TOKEN;
        this.method = RequestInfo.Method.POST;
        this.host = ServerConstant.HOST;
        this.contentType = "application/x-www-form-urlencoded";
        //设置https报文的头部
        Map<String,Object> headMap = new HashMap<String,Object>();
        headMap.put("Host",host);
        headMap.put("Content-Type",contentType);
        httpPostMethod = new HttpPostMethod(method);
        httpPostMethod.setHeader(headMap);

        //设置https请求报文的body部分
        Map<String,Object> bodyMap = new HashMap<String,Object>();
        if (appKey != null) {
            bodyMap.put("appKey",appKey);
        }
        if (appSecret != null) {
            bodyMap.put("appSecret",appSecret);
        }
        httpPostMethod.setCompleteUrl(url,bodyMap);
    }

    public BasicResponse<AccessToken> executeApi() {
        BasicResponse response = null;
        HttpResponse httpResponse = httpPostMethod.execute();

        try {
            //中间进行了一次字段转换，不清楚具体实现的效果
            response = JSON.parseObject(httpResponse.getEntity().getContent(), BasicResponse.class);
            response.setJson(JSON.toJSONString(response));
            Object data = JSON.parseObject(JSON.toJSONString(response.getDataInternal()), AccessToken.class);
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
