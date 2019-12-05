package cn.sciento.fluorite.response;

/**
 * @author wumu
 * @version V1.0
 * @date 5/21/18
 * @time 4:36 PM
 */
public class OpenLiveResponse {

    private String deviceSerial;

    private String channelNo;

    private String ret;

    private String desc;


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

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
