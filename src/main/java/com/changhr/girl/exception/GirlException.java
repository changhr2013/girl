package com.changhr.girl.exception;

import com.changhr.girl.enums.ResultEnum;

/**
 * Created by Tony on 2018/3/8.
 */
public class GirlException extends RuntimeException {

    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
