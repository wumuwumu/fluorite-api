package cn.sciento.fluorite.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 指定设备的基本信息
 * @author wumu
 * @version V1.0
 * @date 4/18/18
 * @time 2:37 PM
 */
public class DeviceInfoResponse {
    @JSONField(name = "deviceSerial")
    public String deviceSerial;//设备序列号
    @JSONField(name ="deviceName")
    public String deviceName;//设备名称
    @JSONField(name ="model")
    public String model;//设备型号
    @JSONField(name ="status")
    public int status;//在线状态：0-不在线，1-在线
    @JSONField(name ="defence")
    public int defence;//具有防护能力的设备布撤防状态：0-睡眠，8-在家，16-外出，普通IPC布撤防状态：0-撤防,1-布防
    @JSONField(name ="isEncrypt")
    public int isEncrypt;//是否加密：0-不加密，1-加密
    @JSONField(name ="alarmSoundMode")
    public int alarmSoundMode;//报警声音模式：0-短叫，1-长叫，2-静音
    @JSONField(name ="offlineNotify")
    public int offlineNotify;//设备下线是否通知：0-不通知 1-通知

    public String getDeviceSerial() {
        return deviceSerial;
    }

    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getIsEncrypt() {
        return isEncrypt;
    }

    public void setIsEncrypt(int isEncrypt) {
        this.isEncrypt = isEncrypt;
    }

    public int getAlarmSoundMode() {
        return alarmSoundMode;
    }

    public void setAlarmSoundMode(int alarmSoundMode) {
        this.alarmSoundMode = alarmSoundMode;
    }

    public int getOfflineNotify() {
        return offlineNotify;
    }

    public void setOfflineNotify(int offlineNotify) {
        this.offlineNotify = offlineNotify;
    }

}
