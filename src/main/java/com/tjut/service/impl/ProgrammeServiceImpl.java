package com.tjut.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tjut.dao.ProgrammeDao;
import com.tjut.pojo.dto.CommonResult;
import com.tjut.pojo.dto.param.*;
import com.tjut.pojo.dto.result.ProgramResult;
import com.tjut.pojo.dto.result.ProgramResultList;
import com.tjut.pojo.dto.result.ProgramSearchResult;
import com.tjut.pojo.dto.result.ProgramSearchResultList;
import com.tjut.pojo.po.Programme;
import com.tjut.service.ProgrammeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProgrammeServiceImpl implements ProgrammeService {
    private ProgrammeDao programmeDao;
    @Autowired
    public void setProgrammeDao(ProgrammeDao programmeDao){
        this.programmeDao = programmeDao;
    }

    //获得所有节目信息
    @Override
    public CommonResult<ProgramResultList> getProgramList(Integer pageNUm) {
        IPage<Programme> page=new Page<>(pageNUm,9);
        List<Programme> programmes=programmeDao.selectPage(page,null).getRecords();
        List<ProgramResult> programResults = new ArrayList<>();
        for(Programme programme:programmes){
            ProgramResult programResult = new ProgramResult();
            programResult.setId(programme.getId());
            programResult.setTypeName(programme.getType());
            programResult.setName(programme.getName());
            programResult.setView(programme.getPoint());
            programResult.setActorList(programme.getActors());
            programResults.add(programResult);
        }
        return CommonResult.success(new ProgramResultList(programResults));
    }

    //按照条件搜索节目
    @Override
    public CommonResult<ProgramSearchResultList> getProgramByCondition(Integer type, Integer num, String name) {
        Programme tempProgramme = new Programme();
        tempProgramme.setType(String.valueOf(type));
        tempProgramme.resetType();
        LambdaQueryWrapper<Programme> lqw = new LambdaQueryWrapper<>();
        lqw.eq(null!=name,Programme::getName,name);
        lqw.eq(null!=tempProgramme.getType(),Programme::getType,tempProgramme.getType());
        if(null != num){
            if(num < 3){
                lqw.eq(true,Programme::getActorsNum, num);
            }else {
                lqw.ge(true,Programme::getActorsNum, num);
            }
        }
        List<ProgramSearchResult> programSearchResults = new ArrayList<>();
        for(Programme programme:programmeDao.selectList(lqw)){
            ProgramSearchResult programSearchResult = new ProgramSearchResult();
            programSearchResult.setId(programme.getId());
            programSearchResult.setTypeName(programme.getType());
            programSearchResult.setName(programme.getName());
            programSearchResult.setView(programme.getPoint());
            programSearchResult.setActorList(programme.getActors());
            programSearchResult.setNum(programme.getActorsNum());
            programSearchResults.add(programSearchResult);
        }
        return CommonResult.success(new ProgramSearchResultList(programSearchResults));
    }

    //新增节目
    @Override
    public CommonResult<String> addProgram(AddProgramParam addProgramParam) {
        Programme programme = new Programme();
        programme.setType(addProgramParam.getType());
        programme.resetType();
        programme.setName(addProgramParam.getName());
        programme.setPoint(addProgramParam.getPoint());
        programme.setActors(addProgramParam.getActors());
        programme.setActorsNum();
        programmeDao.insert(programme);
        return CommonResult.addSuccess();
    }

    //删除节目
    @Override
    public CommonResult<String> deleteProgram(DeleteProgramParam deleteProgramParam) {
        programmeDao.deleteById(deleteProgramParam.getId());
        return CommonResult.deleteSuccess();
    }

    //更新节目
    @Override
    public CommonResult<String> updateProgram(ModifyProgramParam modifyProgramParam) {
        UpdateWrapper<Programme> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",modifyProgramParam.getId());
        Programme programme = new Programme();
        programme.setType(modifyProgramParam.getType());
        programme.resetType();
        programme.setName(modifyProgramParam.getName());
        programme.setPoint(modifyProgramParam.getPoint());
        programme.setActors(modifyProgramParam.getActors());
        programme.setActorsNum();
        Integer rows = programmeDao.update(programme, updateWrapper);
        return CommonResult.updateSuccess();
    }
}
