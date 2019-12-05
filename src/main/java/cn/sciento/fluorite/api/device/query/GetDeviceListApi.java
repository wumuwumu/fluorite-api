package cn.sciento.fluorite.api.device.query;

import cn.sciento.fluorite.api.AbstractAPI;
import cn.sciento.fluorite.constants.ServerConstant;
import cn.sciento.fluorite.http.HttpPostMethod;
import cn.sciento.fluorite.request.RequestInfo;
import cn.sciento.fluorite.response.BasicResponse;
import cn.sciento.fluorite.response.DeviceListResponse;
import cn.sciento.fluorite.response.PageResponse;
import cn.sciento.fluorite.utils.HttpUtil;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 查询用户下设备基本信息列表
 *注：个人版设备接入上限：10台。无分页功能；如需要完善的功能，请升级为企业版
 * @author wumu
 * @version V1.0
 * @date 4/18/18
 * @time 2:30 PM
 */
public class GetDeviceListApi extends AbstractAPI {

    private int pageStart;//分页起始页，从0开始
    private int pageSize;//分页大小，默认是10，最大是50
    private HttpPostMethod httpPostMethod;

    public GetDeviceListApi(String url,String accessToken,int pageStart,int pageSize) {
        this.url = url;
        this.accessToken = accessToken;
        this.method = RequestInfo.Method.POST;
        this.pageSize = pageSize;
        this.pageStart = pageStart;
        this.host = ServerConstant.HOST;
        this.contentType = "application/x-www-form-urlencoded";

        //设置http的head
        HttpUtil httpUtil = new HttpUtil();
        Map<String,Object> headMap = httpUtil.setHeadMap(host,contentType);
        httpPostMethod = new HttpPostMethod(method);
        httpPostMethod.setHeader(headMap);

        //设置http的body
        Map<String,Object> bodyMap = httpUtil.setBodyMap(accessToken,null,null);
        if(pageStart >= 0) {
            bodyMap.put("pageStart",pageStart);
        }
        if(pageSize > 0){
            bodyMap.put("pageSize",pageSize);
        }

        httpPostMethod.setCompleteUrl(url,bodyMap);
    }

    public BasicResponse<List<DeviceListResponse>> executeApi() {
        BasicResponse response = null;
        HttpResponse httpResponse = httpPostMethod.execute();

        try {
            response = JSON.parseObject(httpResponse.getEntity().getContent(), BasicResponse.class);
            response.setJson(JSON.toJSONString(response));

            // 将json对象转化成DeviceList对象数组ArrayList(DeviceListResponse)
            List<DeviceListResponse> listResponses = new ArrayList<DeviceListResponse>();
            //DeviceListResponse[] deviceListResponses = new DeviceListResponse[];
            Object bs = response.getDataInternal();
            String stringJson = JSON.toJSONString(bs);
            listResponses = JSON.parseObject(stringJson,List.class);
            //JavaType javaType = getCollectionType(ArrayList.class,DeviceListResponse.class);
            //Object data = mapper.readValue(mapper.writeValueAsString(cn.sciento.fluorite.response.getDataInternal()), DeviceListResponse.class);
            response.setData(listResponses);
            PageResponse page = JSON.parseObject(JSON.toJSONString(response.getPageInternal()),PageResponse.class);
            response.setPage(page);
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
