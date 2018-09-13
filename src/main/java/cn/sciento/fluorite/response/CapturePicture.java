package cn.sciento.fluorite.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author wumu
 * @version V1.0
 * @date 4/18/18
 * @time 12:25 PM
 */
public class CapturePicture {

    @JSONField(name="picUrl")
    public String picUrl;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
