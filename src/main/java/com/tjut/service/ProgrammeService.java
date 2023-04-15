package com.tjut.service;

import com.tjut.pojo.dto.CommonResult;
import com.tjut.pojo.dto.param.*;
import com.tjut.pojo.dto.result.ProgramResult;
import com.tjut.pojo.dto.result.ProgramResultList;
import com.tjut.pojo.dto.result.ProgramSearchResult;
import com.tjut.pojo.dto.result.ProgramSearchResultList;
import com.tjut.pojo.po.Programme;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProgrammeService {
    public CommonResult<ProgramResultList> getProgramList(Integer pageNUm);
    public CommonResult<ProgramSearchResultList> getProgramByCondition(Integer type, Integer num, String name);
    public CommonResult<String> addProgram(AddProgramParam addProgramParam);
    public CommonResult<String> deleteProgram(DeleteProgramParam deleteProgramParam);
    public CommonResult<String> updateProgram(ModifyProgramParam modifyProgramParam);


}
