import cn.sciento.fluorite.api.token.GetToken;
import cn.sciento.fluorite.api.weblive.OpenLive;
import cn.sciento.fluorite.response.AccessToken;
import cn.sciento.fluorite.response.BasicResponse;
import cn.sciento.fluorite.response.OpenLiveResponse;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Properties;

/**
 * @author wumu
 * @version V1.0
 * @date 5/20/18
 * @time 2:30 PM
 */
public class Test {

    static  String appKey="";
    static String appSecret="";

    public static void main(String[] args) throws IOException {

//        load();
//        getToken();
        String accessToken =  "at.12y5y6zc2vp1a4o347ccwnn1b2p5bxxn-5j1m3mm1k3-1xt4uep-ebpwm2du0";
        String source = "C19813822:1";
        source = URLEncoder.encode(source, String.valueOf(StandardCharsets.UTF_8));
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

    private static void load() throws IOException {

        InputStream in = Test.class.getClassLoader().getResourceAsStream("config.properties");
        Properties p = new Properties();
        p.load(in);
        System.out.println(p.get("appKey"));
        System.out.println(p.get("appSecret"));
    }
}
