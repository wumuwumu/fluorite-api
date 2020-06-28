package cn.sciento.fluorite.api.account;

import cn.sciento.fluorite.api.AbstractAPI;
import cn.sciento.fluorite.constants.ServerConstant;
import cn.sciento.fluorite.http.HttpPostMethod;
import cn.sciento.fluorite.response.BasicResponse;
import cn.sciento.fluorite.response.account.AccountInfoResponse;
import cn.sciento.fluorite.utils.HttpUtil;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GetAccountListApi extends AbstractAPI {

    private int pageStart = 0;
    private int pageSize = 10;
    private HttpPostMethod httpMethod;//请求方式


    public GetAccountListApi(String accessToken, int pageStart, int pageSize) {
        this.url = ServerConstant.GET_ACCOUNT_LIST;
        this.accessToken = accessToken;
        this.pageStart = pageStart;
        this.pageSize = pageSize;
        HttpUtil httpUtil = new HttpUtil();
        Map<String,Object> headMap = httpUtil.setHeadMap(host,contentType);
        httpMethod = new HttpPostMethod(method);
        httpMethod.setHeader(headMap);

        Map<String,Object> bodyMap = httpUtil.setBodyMap(accessToken,null,null);
        bodyMap.put("pageStart",this.pageStart);
        bodyMap.put("pageSize",this.pageSize);
        httpMethod.setCompleteUrl(url,bodyMap);
    }

    public BasicResponse<List<AccountInfoResponse>> executeApi() {
        BasicResponse response = null;
        HttpResponse httpResponse = httpMethod.execute();

        try {
            response = JSON.parseObject(httpResponse.getEntity().getContent(),BasicResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            httpMethod.httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

}
