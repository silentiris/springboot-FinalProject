package com.tjut.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tjut.dao.ProgrammeDao;
import com.tjut.entity.Programme;
import com.tjut.service.ProgrammeService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProgrammeServiceImpl implements ProgrammeService {
    @Autowired
    private ProgrammeDao programmeDao;
    @Override
    public List<Programme> getProgramList(Integer pageNUm) {
        IPage<Programme> page=new Page<>(pageNUm,9);
        return programmeDao.selectPage(page,null).getRecords();
    }

    @Override
    public List<Programme> getProgramByCondition(Integer type, Integer num, String name) {
        LambdaQueryWrapper<Programme> lqw = new LambdaQueryWrapper<Programme>();
        lqw.eq(null!=name,Programme::getName,name);
        lqw.ge(null!=num,Programme::getActorsNum, num);
        lqw.eq(null!=type,Programme::getType,type);
        return programmeDao.selectList(lqw);
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
        Programme programme1 = new Programme();
        programme1.setName(programme.getName());
        programme1.setActors(programme.getActors());
        programme1.setType(programme.getType());
        programme1.setPoint(programme.getPoint());
        Integer rows = programmeDao.update(programme1, updateWrapper);
        return true;
    }
}
