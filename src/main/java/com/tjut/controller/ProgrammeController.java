package com.tjut.controller;

import com.tjut.pojo.dto.param.AddProgramParam;
import com.tjut.pojo.dto.param.DeleteProgramParam;
import com.tjut.pojo.dto.param.ModifyProgramParam;
import com.tjut.pojo.dto.CommonResult;
import com.tjut.pojo.dto.result.ProgramResultList;
import com.tjut.pojo.dto.result.ProgramSearchResultList;
import com.tjut.service.ProgrammeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ProgrammeController {
    private ProgrammeService programmeService;
    @Autowired
    public void setProgrammeService(ProgrammeService programmeService){
        this.programmeService = programmeService;
    }

    @GetMapping("/get/programList")
    public CommonResult<ProgramResultList> queryProgramList(Integer pageNum){
        return programmeService.getProgramList(pageNum);
    }
    @GetMapping("/get/search")
    public CommonResult<ProgramSearchResultList> queryProgramByCondition(Integer type, Integer num, String name){
        return programmeService.getProgramByCondition(type,num,name);
    }
    @PostMapping("/add/program")
    public CommonResult<String> addProgram(@RequestBody AddProgramParam addProgramParam){
        return programmeService.addProgram(addProgramParam);
    }
    @PostMapping("/delete/program")
    public CommonResult<String> deleteProgram(@RequestBody DeleteProgramParam deleteProgramParam){
        return programmeService.deleteProgram(deleteProgramParam);
    }

    @PostMapping("/update/program")
    public CommonResult<String> modifyProgram(@RequestBody ModifyProgramParam modifyProgramParam){
        return programmeService.updateProgram(modifyProgramParam);
    }

}

