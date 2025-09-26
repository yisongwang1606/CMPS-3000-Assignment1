package com.zb.util;//包的工具类

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult {
    private String msg;
    private Integer code;
    private Object data;

    public static ResponseResult success(Object data) {
        ResponseResult result=new ResponseResult("success!", 200, data);
        return result;
    }

    public static ResponseResult fail(String msg,Integer code, Object data) {
        ResponseResult result=new ResponseResult(msg, code, data);
        return result;
    }


}
