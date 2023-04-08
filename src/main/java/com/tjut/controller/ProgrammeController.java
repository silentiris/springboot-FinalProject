package com.tjut.controller;

import com.tjut.controller.Result.Code;
import com.tjut.controller.Result.ProgrammeList;
import com.tjut.controller.Result.Result;
import com.tjut.entity.Programme;
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
    public Result getProgramList(Integer pageNum){
        List<Programme> programmes = programmeService.getProgramList(pageNum);
        System.out.println("page:  "+pageNum);
        return new Result(Code.OPERATE_OK,"请求正常").data("programResults",programmes);
    }
    @RequestMapping("/get/search")
    @ResponseBody
    public Result queryProgramByCondition(Integer type,Integer num,String name){
        List<Programme> programmes = programmeService.getProgramByCondition(type,num,name);
        return new Result(Code.OPERATE_OK,"请求正常").data("programSearchResults",programmes);
    }

    @RequestMapping("/add/program")
    @ResponseBody
    public Result addProgram(@RequestBody Programme programme){
        System.out.println("Start... queryProgramListByCondition");
        System.out.println("programme :"+programme);
        programme.setActorsNum();
        programmeService.addProgram(programme);
        return new Result(Code.OPERATE_OK,"添加成功");
    }
    @RequestMapping("/delete/program")
    @ResponseBody
    public Result deleteProgram(@RequestBody Programme programme){
        System.out.println("Start... deleteProgram");
        System.out.println("programme :"+programme);
        programmeService.deleteProgram( programme.getId());
        return new Result(Code.OPERATE_OK,"删除成功");
    }

    @RequestMapping("/update/program")
    @ResponseBody
    public Result modifyProgram(@RequestBody Programme programme){
        System.out.println("Start... modifyProgram");
        System.out.println("programme :"+programme);
        programmeService.updateProgram(programme);
        return new Result(Code.OPERATE_OK,"更新成功");
    }

}

