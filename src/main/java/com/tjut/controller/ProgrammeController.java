package com.tjut.controller;

import com.tjut.pojo.dto.param.AddProgramParam;
import com.tjut.pojo.dto.param.DeleteProgramParam;
import com.tjut.pojo.dto.param.ModifyProgramParam;
import com.tjut.pojo.dto.CommonResult;
import com.tjut.pojo.dto.result.BlankResult;
import com.tjut.pojo.dto.result.ProgramResultList;
import com.tjut.pojo.dto.result.ProgramSearchResultList;
import com.tjut.service.ProgrammeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@Validated
public class ProgrammeController {
    private ProgrammeService programmeService;
    @Autowired
    public void setProgrammeService(ProgrammeService programmeService){
        this.programmeService = programmeService;
    }

    @GetMapping("/get/programList")
    public CommonResult<ProgramResultList> queryProgramList(@Positive(message = "页码不能为空") Integer pageNum){
        return programmeService.getProgramList(pageNum);
    }
    @GetMapping("/get/search")
    public CommonResult<ProgramSearchResultList> queryProgramByCondition(Integer type,
                                                                         @Positive(message = "演员人数必须为正整数") Integer num,
                                                                         String name){
        return programmeService.getProgramByCondition(type,num,name);
    }
    @PostMapping("/add/program")
    public CommonResult<BlankResult> addProgram(@RequestBody@Valid AddProgramParam addProgramParam){
        return programmeService.addProgram(addProgramParam);
    }
    @PostMapping("/delete/program")
    public CommonResult<BlankResult> deleteProgram(@RequestBody@Valid DeleteProgramParam deleteProgramParam){
        return programmeService.deleteProgram(deleteProgramParam);
    }

    @PostMapping("/update/program")
    public CommonResult<BlankResult> modifyProgram(@RequestBody@Valid ModifyProgramParam modifyProgramParam){
        return programmeService.updateProgram(modifyProgramParam);
    }

}

