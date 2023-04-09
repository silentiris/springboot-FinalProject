package com.tjut.service;

import com.tjut.pojo.bo.ProgramResults;
import com.tjut.pojo.bo.ProgramSearchResults;
import com.tjut.pojo.entity.Programme;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ProgrammeService {
    public List<ProgramResults> getProgramList(Integer pageNUm);
    public List<ProgramSearchResults> getProgramByCondition(Integer type, Integer num, String name);
    public boolean addProgram(Programme programme);
    public boolean deleteProgram(Integer id);
    public boolean updateProgram(Programme programme);


}
