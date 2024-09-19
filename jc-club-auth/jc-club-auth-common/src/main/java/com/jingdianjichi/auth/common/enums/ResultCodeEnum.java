package com.jingdianjichi.auth.common.enums;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    SUCCESS(200,"成功"),
    FAIL(500,"失败");
    private int code;
    private String message;

    ResultCodeEnum(int code,String message){
        this.code = code;
        this.message = message;
    }

    public static ResultCodeEnum getByCode(int codeVal){
        for (ResultCodeEnum resultCodeEnum : ResultCodeEnum.values()){
            if (resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }
}
