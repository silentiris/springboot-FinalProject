package com.tjut.pojo.entity;

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
    public void resetType(){
        switch(type){
            case "1":
                type = "歌舞";
                break;
            case "2":
                type = "戏曲";
                break;
            case "3":
                type = "小品";
                break;
            case "4":
                type = "相声";
                break;
            case "5":
                type = "武术";
                break;
            case "6":
                type = "其他";
                break;
        }
    }

    public void setActorsNum() {
        int cnt = 1;
        for(int i = 0;i<actors.length();i++){
            char c= actors.charAt(i);
            if(c == '，') cnt++;
        }
        actorsNum = cnt;
    }
}
