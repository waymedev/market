package cc.nefuer.market.common;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author jimi花
 * @date 2018/7/24
 */
public class RestData {
    /**
     * code 标识码
     */
    private int code;

    /**
     * data 数据域
     */
    private Object data;

    /**
     * 分页信息
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Page page;

    public RestData(int code, Object data) {
        this.code = code;
        this.data = data;
        this.page = null;
    }

    public RestData(Object data, Page page) {
        this.code = 0;
        this.data = data;
        this.page = page;
    }

    public RestData(Object data) {
        this.code = 0;
        this.data = data;
        this.page = null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
