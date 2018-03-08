package com.changhr.girl.utils;

import com.changhr.girl.domain.Girl;
import com.changhr.girl.domain.Result;

/**
 * Created by changhr2013 on 2018/3/7.
 */
public class ResultUtil {

    public static Result success(Girl girl){
        Result result=new Result();
        result.setCode(0);
        result.setMessage("成功");
        result.setData(girl);
        return result;
    }

    public static void success(){
        success(null);
    }

    public static Result failed(Integer code,String message){
        Result result=new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(null);
        return result;
    }
}
