package com.tjut.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tjut.dao.ProgrammeDao;
import com.tjut.pojo.bo.ProgramResults;
import com.tjut.pojo.bo.ProgramSearchResults;
import com.tjut.pojo.entity.Programme;
import com.tjut.service.ProgrammeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProgrammeServiceImpl implements ProgrammeService {
    @Autowired
    private ProgrammeDao programmeDao;
    @Override
    public List<ProgramResults> getProgramList(Integer pageNUm) {
        IPage<Programme> page=new Page<>(pageNUm,9);
        List<Programme> programmes=programmeDao.selectPage(page,null).getRecords();
        List<ProgramResults> programResultsList = new ArrayList<>();
        for(Programme programme:programmes){
            ProgramResults programResults = new ProgramResults();
            programResults.setId(programme.getId());
            programResults.setActorList(programme.getActors());
            programResults.setView(programme.getPoint());
            programResults.setTypeName(programme.getType());
            programResults.setName(programme.getName());
            programResultsList.add(programResults);
        }
        return programResultsList;
    }

    @Override
    public List<ProgramSearchResults> getProgramByCondition(Integer type, Integer num, String name) {
        LambdaQueryWrapper<Programme> lqw = new LambdaQueryWrapper<Programme>();
        lqw.eq(null!=name,Programme::getName,name);
        lqw.ge(null!=num,Programme::getActorsNum, num);
        lqw.eq(null!=type,Programme::getType,type);
        List<Programme> programmes = programmeDao.selectList(lqw);
        List<ProgramSearchResults> programSearchResultsList = new ArrayList<>();
        for(Programme programme:programmes){
            ProgramSearchResults programSearchResults = new ProgramSearchResults();
            programSearchResults.setView(programme.getPoint());
            programSearchResults.setNum(programme.getActorsNum());
            programSearchResults.setName(programme.getName());
            programSearchResults.setId(programme.getId());
            programSearchResults.setTypeName(programme.getType());
            programSearchResults.setActorList(programme.getActors());
            programSearchResultsList.add(programSearchResults);
        }
        return programSearchResultsList;
    }

    @Override
    public boolean addProgram(Programme programme) {
        System.out.println("starting insert...");
        programmeDao.insert(programme);
        System.out.println("insert successfully!");
        return true;
    }

    @Override
    public boolean deleteProgram(Integer id) {
        programmeDao.deleteById(id);
        return true;
    }

    @Override
    public boolean updateProgram(Programme programme) {
        UpdateWrapper<Programme> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",programme.getId());
        programme.setActorsNum();
        Programme programme1 = new Programme();
        programme1.setName(programme.getName());
        programme1.setActors(programme.getActors());
        programme1.setType(programme.getType());
        programme1.setPoint(programme.getPoint());
        programme1.setActorsNum(programme.getActorsNum());
        Integer rows = programmeDao.update(programme1, updateWrapper);
        return true;
    }
}
