package cn.sciento.fluorite.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author wumu
 * @version V1.0
 * @date 4/18/18
 * @time 11:13 AM
 */
public class BasicResponse<T> {

    public String code; //返回类型码
    public String msg; //返回类型描述
    public T data; //返回数据data
    public PageResponse page; //返回分页信息
    // TODO 这里有重复的字段
    @JSONField(name="data")
    public Object dataInternal;
    @JSONField(name="page")
    public Object pageInternal;
    @JSONField(serialize = false)
    public String json;

    public PageResponse getPage() {
        return page;
    }

    public void setPage(PageResponse page) {
        this.page = page;
    }
    @JSONField(name = "page")
    public Object getPageInternal() {
        return pageInternal;
    }
    @JSONField(name="page")
    public void setPageInternal(Object pageInternal) {
        this.pageInternal = pageInternal;
    }

    @JSONField(name="data")
    public Object getDataInternal() {
        return dataInternal;
    }
    @JSONField(name="data")
    public void setDataInternal(Object dataInternal) {
        this.dataInternal = dataInternal;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BasicResponse{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", page=" + page +
                ", dataInternal=" + dataInternal +
                ", pageInternal=" + pageInternal +
                ", json='" + json + '\'' +
                '}';
    }
}
