package com.jingdianjichi.subject.common.enums;

import lombok.Getter;

@Getter
public enum IsDeletedFlagEnum {
    DELETED(1,"已删除"),
    UN_DELETE(0,"未删除");
    private int code;
    private String message;

    IsDeletedFlagEnum(int code, String message){
        this.code = code;
        this.message = message;
    }

    public static IsDeletedFlagEnum getByCode(int codeVal){
        for (IsDeletedFlagEnum resultCodeEnum : IsDeletedFlagEnum.values()){
            if (resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }
}
