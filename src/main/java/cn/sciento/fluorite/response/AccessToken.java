package cn.sciento.fluorite.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author wumu
 * @version V1.0
 * @date 4/18/18
 * @time 10:56 AM
 */
public class AccessToken {

    @JSONField(name="accessToken")
    public String accessToken;
    @JSONField(name = "expireTime")
    public String expireTime;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }
}
