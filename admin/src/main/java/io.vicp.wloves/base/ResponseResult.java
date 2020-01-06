package io.vicp.wloves.base;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuzw
 * @version <b>1.0.0</b>
 * @date 2019/12/31 11:24
 */
@Data
public class ResponseResult {
    public static final String SUCCESS_CODE = "00000";
    public static final String SUCCESS_MSG = "success";

    /** 状态码 */
    public String code;

    /** 返回内容 */
    public String msg;

    /** 数据对象 */
    public Object data;

    public Map<String, Object> extraData;

    public ResponseResult() {
        this.code = SUCCESS_CODE;
        this.msg = SUCCESS_MSG;
    }

    public ResponseResult(Object data) {
        this.code = SUCCESS_CODE;
        this.msg = SUCCESS_MSG;
        this.data = data;
    }

    public ResponseResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public void addExtraData(String key, Object value) {
        if (extraData == null) {
            extraData = new HashMap<>();
        }
        extraData.put(key, value);
    }
}
