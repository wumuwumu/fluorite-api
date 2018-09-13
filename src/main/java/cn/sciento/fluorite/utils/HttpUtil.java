package cn.sciento.fluorite.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wumu
 * @version V1.0
 * @date 4/18/18
 * @time 11:44 AM
 */
public class HttpUtil {
    /**
     * 设置http headMap
     * @param host
     * @param content_type
     * @return
     */
    public Map<String,Object> setHeadMap(String host, String content_type) {
        Map<String,Object> headMap = new HashMap<String,Object>();
        headMap.put("Host",host);
        headMap.put("Content_Type",content_type);

        return headMap;
    }

    public Map<String,Object> setBodyMap(String accessToken,String deviceSerial,String validateCode) {
        Map<String,Object> bodyMap = new HashMap<String,Object>();
        if (accessToken != null) {
            bodyMap.put("accessToken",accessToken);
        }
        if (deviceSerial != null) {
            bodyMap.put("deviceSerial",deviceSerial);
        }
        if (validateCode != null) {
            bodyMap.put("validateCode",validateCode);
        }

        return bodyMap;
    }
}
