package com.tjut.service;

import com.tjut.pojo.dto.CommonResult;
import com.tjut.pojo.dto.param.*;
import com.tjut.pojo.dto.result.*;
import com.tjut.pojo.po.Programme;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProgrammeService {
    public CommonResult<ProgramResultList> getProgramList(Integer pageNUm);
    public CommonResult<ProgramSearchResultList> getProgramByCondition(Integer type, Integer num, String name);
    public CommonResult<BlankResult> addProgram(AddProgramParam addProgramParam);
    public CommonResult<BlankResult> deleteProgram(DeleteProgramParam deleteProgramParam);
    public CommonResult<BlankResult> updateProgram(ModifyProgramParam modifyProgramParam);


}
