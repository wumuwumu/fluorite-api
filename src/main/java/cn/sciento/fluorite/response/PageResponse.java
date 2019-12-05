package cn.sciento.fluorite.response;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author wumu
 * @version V1.0
 * @date 4/18/18
 * @time 11:14 AM
 */
public class PageResponse {

    @JSONField(name="total")
    public int total;
    @JSONField(name="page")
    public int page;
    @JSONField(name="size")
    public int size;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
