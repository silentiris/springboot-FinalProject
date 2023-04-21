package com.tjut.pojo.dto.ResultEnum;

import lombok.Getter;

@Getter
public enum ResultEnum {
    SUCCESS("00000", "请求正常"),
    FAILED("A0400", "请求失败"),
    ADD_SUCCEED("00000", "添加成功"),
    DELETE_SUCCEED("00000", "删除成功"),
    UPDATE_SUCCEED("00000", "更新成功");


    private final String code;
    private final String message;

    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}