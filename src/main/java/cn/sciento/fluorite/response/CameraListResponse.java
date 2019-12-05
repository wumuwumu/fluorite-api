package cn.sciento.fluorite.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 获取摄像头监控点的返回信息
 * @author wumu
 * @version V1.0
 * @date 4/18/18
 * @time 2:43 PM
 */
public class CameraListResponse {
    @JSONField(name = "deviceSerial")
    public String deviceSerial;//设备序列号
    @JSONField(name = "channelNo")
    public String channelNo;//通道号
    @JSONField(name = "channelName")
    public String channelName;//通道名
    @JSONField(name = "status")
    public int status;//在线状态：0-不在线，1-在线
    @JSONField(name = "isShared")
    public String isShared;//分享状态：1-分享所有者，0-未分享，2-分享接受者（表示此摄像头是别人分享给我的）
    @JSONField(name = "picUrl")
    public String picUrl;//图片地址（大图），若在萤石客户端设置封面则返回封面图片，未设置则返回默认图片
    @JSONField(name = "isEncrypt")
    public int isEncrypt;//是否加密，0：不加密，1：加密
    @JSONField(name = "videoLevel")
    public int videoLevel;//视频质量：0-流畅，1-均衡，2-高清，3-超清

    public String getDeviceSerial() {
        return deviceSerial;
    }

    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }

    public String getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(String channelNo) {
        this.channelNo = channelNo;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getIsShared() {
        return isShared;
    }

    public void setIsShared(String isShared) {
        this.isShared = isShared;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getIsEncrypt() {
        return isEncrypt;
    }

    public void setIsEncrypt(int isEncrypt) {
        this.isEncrypt = isEncrypt;
    }

    public int getVideoLevel() {
        return videoLevel;
    }

    public void setVideoLevel(int videoLevel) {
        this.videoLevel = videoLevel;
    }
}
