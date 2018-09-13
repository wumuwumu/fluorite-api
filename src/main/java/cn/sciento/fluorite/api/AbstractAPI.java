package cn.sciento.fluorite.api;

import cn.sciento.fluorite.constants.ServerConstant;
import cn.sciento.fluorite.request.RequestInfo;

/**
 * @author wumu
 * @version V1.0
 * @date 4/18/18
 * @time 11:01 AM
 */
public  class AbstractAPI {
    public String accessToken;//连接密匙
    public String url;//连接的url
    public RequestInfo.Method method = RequestInfo.Method.POST;//请求方式
    public String host = ServerConstant.HOST;
    public String contentType = "application/x-www-form-urlencoded";


}
