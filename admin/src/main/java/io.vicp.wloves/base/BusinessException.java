package io.vicp.wloves.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zhuzw
 * @version <b>1.0.0</b>
 * @date 2019/10/26 10:27
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
public class BusinessException extends RuntimeException {

    private String code;
    private String msg;

    public BusinessException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(ExceptionEnum ee) {
        this.code = ee.getCode();
        this.msg = ee.getMsg();
    }
}
