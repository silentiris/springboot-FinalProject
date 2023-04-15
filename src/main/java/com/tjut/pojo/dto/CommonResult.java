package com.tjut.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tjut.pojo.dto.ResultEnum.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CommonResult<T> {
    private String code;
    private String message;
    private T data;

    public static <T> CommonResult<T> success() {
        return new CommonResult<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), null);
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }
    public static <T> CommonResult<T> addSuccess(){
        return new CommonResult<>(ResultEnum.ADD_SUCCEED.getCode(),ResultEnum.ADD_SUCCEED.getMessage(),null);
    }
    public static <T> CommonResult<T> deleteSuccess(){
        return new CommonResult<>(ResultEnum.DELETE_SUCCEED.getCode(),ResultEnum.DELETE_SUCCEED.getMessage(),null);
    }
    public static <T> CommonResult<T> updateSuccess(){
        return new CommonResult<>(ResultEnum.UPDATE_SUCCEED.getCode(),ResultEnum.UPDATE_SUCCEED.getMessage(),null);
    }
}