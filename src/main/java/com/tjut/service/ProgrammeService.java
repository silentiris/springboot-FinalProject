package com.tjut.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tjut.entity.Programme;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProgrammeService {
    public List<Programme> getProgramList(Integer pageNUm);
    public List<Programme> getProgramByCondition(Integer type,Integer num,String name);
    public boolean addProgram(Programme programme);
    public boolean deleteProgram(Integer id);
    public boolean updateProgram(Programme programme);


}
