package com.tjut.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tjut.common.ProgrammeCommon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

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
        actorsNum = ProgrammeCommon.setActorNum(actors);
    }
}
