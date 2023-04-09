package com.tjut.controller;

import com.tjut.pojo.bo.ProgramResults;
import com.tjut.pojo.bo.ProgramSearchResults;
import com.tjut.pojo.dto.Code;
import com.tjut.pojo.dto.Result;
import com.tjut.pojo.entity.Programme;
import com.tjut.service.ProgrammeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ProgrammeController {
    @Autowired
    private ProgrammeService programmeService;

    @RequestMapping("/get/programList")
    @ResponseBody
    public Result queryProgramList(Integer pageNum){
        List<ProgramResults> programResults = programmeService.getProgramList(pageNum);
        return new Result(Code.OPERATE_OK,"请求正常").data("programResults",programResults);
    }
    @RequestMapping("/get/search")
    @ResponseBody
    public Result queryProgramByCondition(Integer type,Integer num,String name){
        List<ProgramSearchResults> programSearchResult = programmeService.getProgramByCondition(type,num,name);
        return new Result(Code.OPERATE_OK,"请求正常").data("programSearchResults",programSearchResult);
    }

    @RequestMapping("/add/program")
    @ResponseBody
    public Result addProgram(@RequestBody Programme programme){
        programme.setActorsNum();
        programme.resetType();
        programmeService.addProgram(programme);
        return new Result(Code.OPERATE_OK,"添加成功");
    }
    @RequestMapping("/delete/program")
    @ResponseBody
    public Result deleteProgram(@RequestBody Programme programme){
        programmeService.deleteProgram( programme.getId());
        return new Result(Code.OPERATE_OK,"删除成功");
    }

    @RequestMapping("/update/program")
    @ResponseBody
    public Result modifyProgram(@RequestBody Programme programme){
        System.out.println("Start... modifyProgram");
        System.out.println("programme :"+programme);
        programme.resetType();
        programmeService.updateProgram(programme);
        return new Result(Code.OPERATE_OK,"更新成功");
    }

}

