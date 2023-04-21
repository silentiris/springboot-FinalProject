package com.tjut.util;

import com.tjut.pojo.dto.result.ProgramResult;
import com.tjut.pojo.dto.result.ProgramSearchResult;
import com.tjut.pojo.po.Programme;

public class ResultConvertUtil {
    public static ProgramResult ProgramResultUtil(Programme programme){
        ProgramResult programResult = new ProgramResult();
        programResult.setId(programme.getId());
        programResult.setTypeName(programme.getType());
        programResult.setName(programme.getName());
        programResult.setView(programme.getPoint());
        programResult.setActorList(programme.getActors());
        return programResult;
    }
    public static ProgramSearchResult programSearchResultUtil(Programme programme){
        ProgramSearchResult programSearchResult = new ProgramSearchResult();
        programSearchResult.setId(programme.getId());
        programSearchResult.setTypeName(programme.getType());
        programSearchResult.setName(programme.getName());
        programSearchResult.setView(programme.getPoint());
        programSearchResult.setActorList(programme.getActors());
        programSearchResult.setNum(programme.getActorsNum());
        return programSearchResult;
    }
}
