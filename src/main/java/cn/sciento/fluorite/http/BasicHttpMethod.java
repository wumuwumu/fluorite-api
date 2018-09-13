package cn.sciento.fluorite.http;

import cn.sciento.fluorite.request.RequestInfo;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Set;

/**
 * @author wumu
 * @version V1.0
 * @date 4/18/18
 * @time 11:07 AM
 */
public abstract class BasicHttpMethod implements RequestInfo {
    public CloseableHttpClient httpClient;
    public HttpRequestBase httpRequestBase;
    public String url;
    public Method method;
    boolean upload;
    public BasicHttpMethod(Method method) {
        this.method = method;
        switch (method) {
            case POST:
                httpRequestBase = new HttpPost();
                break;
            case PUT:
                httpRequestBase = new HttpPut();
                break;
            case DELETE:
                httpRequestBase = new HttpDelete();
                break;
            default:
                httpRequestBase = new HttpGet();
                break;
        }
    }
    @Override
    public void setHeader(Map<String, Object> params) {
        if (params != null) {
            Set<Map.Entry<String,Object>> entries = params.entrySet();
            for(Map.Entry<String,Object> entry : entries)
                httpRequestBase.setHeader(entry.getKey(),(String) entry.getValue());
        }
    }
    @Override
    public void setEntity(String json) {

    }

    @Override
    public void setEntity(Map<String, String> stringMap, Map<String, String> fileMap) {

    }

    @Override
    public void setCompleteUrl(String url, Map<String, Object> params) {
        if(params != null) {
            url += "?";
            Set<Map.Entry<String,Object>> entries = params.entrySet();
            int size = entries.size();
            int index = 0;
            for (Map.Entry<String,Object> entry : entries) {
                url += entry.getKey() + "=" + entry.getValue();
                if(++index < size)
                    url += "&";
            }
        }
        try {
            httpRequestBase.setURI(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setHttpMethod(Method method) {

    }

    @Override
    public void setType(boolean upload) {
        if (!upload) {
            httpRequestBase.addHeader("Content-type","application/x-www-form-urlencoded");
        }
    }

    abstract HttpResponse execute();
}
