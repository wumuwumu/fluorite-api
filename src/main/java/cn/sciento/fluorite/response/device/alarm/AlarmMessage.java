package cn.sciento.fluorite.response.device.alarm;

import java.util.List;

public class AlarmMessage {


    /**
     * alarmId : 24027912025633491
     * alarmName : 设备1
     * alarmType : 10000
     * alarmTime : 4364654646485
     * channelNo : 1
     * isEncrypt : 0
     * isChecked : 0
     * recState : 1
     * preTime : 10
     * delayTime : 30
     * deviceSerial : 427734888
     * alarmPicUrl : https://wuhancloudpictest.ys7.com:8083/HIK_1455866402_724A2B55F5AFe741_06CE56000475452014644?isEncrypted=0&isCloudStored=0
     * relationAlarms : []
     * customerType : null
     * customerInfo : null
     */

    private String alarmId;
    private String alarmName;
    private int alarmType;
    private long alarmTime;
    private int channelNo;
    private int isEncrypt;
    private int isChecked;
    private int recState;
    private int preTime;
    private int delayTime;
    private String deviceSerial;
    private String alarmPicUrl;
    private Object customerType;
    private Object customerInfo;
    private List<?> relationAlarms;

    public String getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(String alarmId) {
        this.alarmId = alarmId;
    }

    public String getAlarmName() {
        return alarmName;
    }

    public void setAlarmName(String alarmName) {
        this.alarmName = alarmName;
    }

    public int getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(int alarmType) {
        this.alarmType = alarmType;
    }

    public long getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(long alarmTime) {
        this.alarmTime = alarmTime;
    }

    public int getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(int channelNo) {
        this.channelNo = channelNo;
    }

    public int getIsEncrypt() {
        return isEncrypt;
    }

    public void setIsEncrypt(int isEncrypt) {
        this.isEncrypt = isEncrypt;
    }

    public int getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(int isChecked) {
        this.isChecked = isChecked;
    }

    public int getRecState() {
        return recState;
    }

    public void setRecState(int recState) {
        this.recState = recState;
    }

    public int getPreTime() {
        return preTime;
    }

    public void setPreTime(int preTime) {
        this.preTime = preTime;
    }

    public int getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(int delayTime) {
        this.delayTime = delayTime;
    }

    public String getDeviceSerial() {
        return deviceSerial;
    }

    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }

    public String getAlarmPicUrl() {
        return alarmPicUrl;
    }

    public void setAlarmPicUrl(String alarmPicUrl) {
        this.alarmPicUrl = alarmPicUrl;
    }

    public Object getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Object customerType) {
        this.customerType = customerType;
    }

    public Object getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(Object customerInfo) {
        this.customerInfo = customerInfo;
    }

    public List<?> getRelationAlarms() {
        return relationAlarms;
    }

    public void setRelationAlarms(List<?> relationAlarms) {
        this.relationAlarms = relationAlarms;
    }
}
