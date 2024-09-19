package com.jingdianjichi.auth.common.enums;

import lombok.Getter;

/**
 * 用户状态枚举
 */
@Getter
public enum AuthUserStatusEnum {
    OPEN(0,"启用"),
    CLOSE(1,"禁用");
    private int code;
    private String message;

    AuthUserStatusEnum(int code, String message){
        this.code = code;
        this.message = message;
    }

    public static AuthUserStatusEnum getByCode(int codeVal){
        for (AuthUserStatusEnum authUserStatusEnum : AuthUserStatusEnum.values()) {
            if (authUserStatusEnum.code == codeVal) {
                return authUserStatusEnum;
            }
        }
        return null;
    }
}
