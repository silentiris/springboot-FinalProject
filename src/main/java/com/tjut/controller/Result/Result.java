package com.tjut.controller.Result;

import com.tjut.entity.Programme;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private String code;
    private String message;
    private Map<String,Object> data = new HashMap<>();

    public Result data(String key,Object value){
        this.data.put(key,value);
        return this;
    }

    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }
}