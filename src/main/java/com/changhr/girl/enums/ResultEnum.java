package com.changhr.girl.enums;

/**
 * Created by Tony on 2018/3/8.
 */
public enum ResultEnum {
    UNKNOWE_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"上小学"),
    MIDDLE_SCHOOL(101,"上初中"),
    ;

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
