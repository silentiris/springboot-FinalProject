package com.tjut.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tjut.common.ProgrammeCommon;
import com.tjut.dao.ProgrammeDao;
import com.tjut.pojo.dto.CommonResult;
import com.tjut.pojo.dto.param.*;
import com.tjut.pojo.dto.result.*;
import com.tjut.pojo.po.Programme;
import com.tjut.service.ProgrammeService;
import com.tjut.util.ParamConvertUtil;
import com.tjut.util.ResultConvertUtil;
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
            programResults.add(ResultConvertUtil.ProgramResultUtil(programme));
        }
        return CommonResult.success(new ProgramResultList(programResults));
    }

    //按照条件搜索节目
    @Override
    public CommonResult<ProgramSearchResultList> getProgramByCondition(Integer type, Integer num, String name) {
        Programme tempProgramme = new Programme();
        if(type != null){
            tempProgramme.setType(ProgrammeCommon.typeMap.get(type));
        }
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
            programSearchResults.add(ResultConvertUtil.programSearchResultUtil(programme));
        }
        return CommonResult.success(new ProgramSearchResultList(programSearchResults));
    }

    //新增节目
    @Override
    public CommonResult<BlankResult> addProgram(AddProgramParam addProgramParam) {
        programmeDao.insert(ParamConvertUtil.AddProgramParamUtil(addProgramParam));
        return CommonResult.addSuccess();
    }

    //删除节目
    @Override
    public CommonResult<BlankResult> deleteProgram(DeleteProgramParam deleteProgramParam) {
        programmeDao.deleteById(deleteProgramParam.getId());
        return CommonResult.deleteSuccess();
    }

    //更新节目
    @Override
    public CommonResult<BlankResult> updateProgram(ModifyProgramParam modifyProgramParam) {
        UpdateWrapper<Programme> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",modifyProgramParam.getId());
        Integer rows = programmeDao.update(ParamConvertUtil.ModifyProgramParamUtil(modifyProgramParam), updateWrapper);
        return CommonResult.updateSuccess();
    }
}
