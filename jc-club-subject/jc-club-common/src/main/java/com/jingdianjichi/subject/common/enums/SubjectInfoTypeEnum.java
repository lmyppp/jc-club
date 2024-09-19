package com.jingdianjichi.subject.common.enums;

import lombok.Getter;

@Getter
public enum SubjectInfoTypeEnum {
    RADIO(1,"单选"),
    MULTIPLE(2,"多选"),
    JUDGE(3,"判断"),
    BRIEF(4,"简答");
    private int code;
    private String message;

    SubjectInfoTypeEnum(int code, String message){
        this.code = code;
        this.message = message;
    }

    public static SubjectInfoTypeEnum getByCode(int codeVal){
        for (SubjectInfoTypeEnum resultCodeEnum : SubjectInfoTypeEnum.values()){
            if (resultCodeEnum.code == codeVal){
                return resultCodeEnum;
            }
        }
        return null;
    }
}
