package com.llz.common.util.enumValidate.enums;

/**
 * 性别
 */
public enum Gender {
    MAN("1","男"),
    WOMEN("2","女");

    private String code;

    private String msg;

    Gender(String code, String msg) {
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
