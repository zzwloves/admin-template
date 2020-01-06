package io.vicp.wloves.base;

/**
 * @author zhuzw
 * @version <b>1.0.0</b>
 * @date 2019/10/26 10:29
 */
public enum ExceptionEnum {

    // S5xxx 系统处理过程中产生异常
    S5000("S5000", "系统未知异常"),

    // U4xxx 用户参数产生的异常
    U4000("U4000", "token已失效，请重新登录"),
    U4001("U4001", "参数错误"),
    U4002("U4002", "用户名或密码错误"),
    U4003("U4003", "新密码不能和旧密码相同"),
    U4004("U4004", "旧密码输入错误");


    private String code;
    private String msg;

    ExceptionEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}