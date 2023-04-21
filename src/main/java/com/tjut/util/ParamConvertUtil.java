package com.tjut.util;

import com.tjut.common.ProgrammeCommon;
import com.tjut.pojo.dto.param.AddProgramParam;
import com.tjut.pojo.dto.param.DeleteProgramParam;
import com.tjut.pojo.dto.param.ModifyProgramParam;
import com.tjut.pojo.po.Programme;

public class ParamConvertUtil {
    public static Programme AddProgramParamUtil(AddProgramParam addProgramParam){
        Programme programme = new Programme();
        programme.setType(ProgrammeCommon.resetType(addProgramParam.getType()));
        programme.setName(addProgramParam.getName());
        programme.setPoint(addProgramParam.getPoint());
        programme.setActors(addProgramParam.getActors());
        programme.setActorsNum(ProgrammeCommon.myGetActorNum(programme.getActors()));
        return programme;
    }
    public static Programme ModifyProgramParamUtil(ModifyProgramParam modifyProgramParam){
        Programme programme = new Programme();
        programme.setType(ProgrammeCommon.resetType(modifyProgramParam.getType()));
        programme.setName(modifyProgramParam.getName());
        programme.setPoint(modifyProgramParam.getPoint());
        programme.setActors(modifyProgramParam.getActors());
        programme.setActorsNum(ProgrammeCommon.myGetActorNum(programme.getActors()));
        return programme;
    }
}
