package com.llz.common.enums;

/**
 * 结果响应码枚举
 */
public enum ResultCodeEnum {

    SUCCESS("0","成功"),
    FAIL("1","失败");

    private String code;

    private String msg;

    ResultCodeEnum(String code, String msg) {
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
