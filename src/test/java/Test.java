import cn.sciento.fluorite.api.token.GetToken;
import cn.sciento.fluorite.api.weblive.OpenLive;
import cn.sciento.fluorite.response.AccessToken;
import cn.sciento.fluorite.response.BasicResponse;
import cn.sciento.fluorite.response.OpenLiveResponse;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author wumu
 * @version V1.0
 * @date 5/20/18
 * @time 2:30 PM
 */
public class Test {

    static  String appKey="0e285eebe6ff42ceb8c05e6026b823dc";
    static String appSecret="85dd470e8785c68b4e6061385b62d4d4";
    public static void main(String[] args) throws UnsupportedEncodingException {


//        getToken();
        String accessToken =  "at.12y5y6zc2vp1a4o347ccwnn1b2p5bxxn-5j1m3mm1k3-1xt4uep-ebpwm2du0";
        String source = "C19813822:1";
        source = URLEncoder.encode(source,"utf8");
        System.out.println(source);
        OpenLive openLive = new OpenLive(accessToken,source);
        BasicResponse<List<OpenLiveResponse>> responseBasicResponse = openLive.executeApi();
        System.out.println(responseBasicResponse);
    }

    private static void getToken() {
        GetToken getToken = new GetToken(appKey, appSecret);
        BasicResponse<AccessToken> response = getToken.executeApi();
        System.out.println(response);
    }
}
