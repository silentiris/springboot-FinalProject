package com.tjut.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("Programme")
public class Programme {
    @TableId(type = IdType.AUTO)
    private int id;
    @TableField(value = "typeName")
    private String type;
    private String name;
    @TableField(value = "view")
    private String point;
    @TableField(value = "actorList")
    private String actors;
    @TableField(value = "actorsNum")
    private int actorsNum;

    public void setActorsNum() {
        int cnt = 1;
        for(int i = 0;i<actors.length();i++){
            char c= actors.charAt(i);
            if(c == '，') cnt++;
        }
        actorsNum = cnt;
    }
}
