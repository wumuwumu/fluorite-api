package cn.sciento.fluorite.constants;

/**
 * @author wumu
 * @version V1.0
 * @date 4/18/18
 * @time 12:04 PM
 */
public interface ServerConstant {
    String HOST = "open.ys7.com";

    String GET_TOKEN = "https://open.ys7.com/api/lapp/token/get";
    //设备管理
    String ADD_DEVICE = "https://open.ys7.com/api/lapp/device/add";
    String CHANGE_DEVICE_NAME = "https://open.ys7.com/api/lapp/device/name/update";
    String DELETE_DEVICE = "https://open.ys7.com/api/lapp/device/delete";
    String CAPTURE_PICTURE = "https://open.ys7.com/api/lapp/device/capture";
    String NVR_RELATED_IPC = "https://open.ys7.com/api/lapp/device/ipc/add";
    String NVR_DELETE_IPC = "https://open.ys7.com/api/lapp/device/ipc/delete";

    //设备查询
    String GET_DEVICE_LIST = "https://open.ys7.com/api/lapp/device/list";
    String GET_DEVICE_INFO = "https://open.ys7.com/api/lapp/device/info";
    String GET_CAMERA_LIST = "https://open.ys7.com/api/lapp/camera/list";

    //web设备直播查询设置
    String WEB_LIVE_PERIOD_ADDRESS  = "https://open.ys7.com/api/lapp/live/address/limited";
    String WEB_LIVE_ADDRESS_LIST = "https://open.ys7.com/api/lapp/live/video/list";
    String WEB_LIVE_OPEN_LIVE = "https://open.ys7.com/api/lapp/live/video/open";

    //云台控制
    String START_PTZ = "https://open.ys7.com/api/lapp/device/ptz/start";
    String STOP_PTZ = "https://open.ys7.com/api/lapp/device/ptz/stop";

    //设备配置
    String STOP_VIDEO_ENCRYPT = "https://open.ys7.com/api/lapp/device/encrypt/off";
}
