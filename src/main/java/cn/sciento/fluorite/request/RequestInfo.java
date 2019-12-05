package cn.sciento.fluorite.request;

import java.util.Map;

/**
 * @author wumu
 * @version V1.0
 * @date 4/18/18
 * @time 10:55 AM
 */
public interface RequestInfo {
    //定义一个枚举
    public enum Method{
        POST,GET,DELETE,PUT
    }

    /**
     * 设置请求格式的头部
     * @param params
     */
    public void setHeader(Map<String, Object> params);

    /**
     * 设置请求的https的body部分
     * @param json
     */
    public void setEntity(String json);


    public void setEntity(Map<String, String> stringMap, Map<String, String> fileMap);

    /**
     * 设置完整的url
     * @param completeUrl
     * @param params
     */
    public void setCompleteUrl(String completeUrl, Map<String, Object> params);

    /**
     * 设置请求方式
     * @param method
     */
    public void setHttpMethod(Method method);

    /**
     * 设置type
     * @param upload
     */
    public void setType(boolean upload);
}
