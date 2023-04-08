package com.tjut.controller.Result;

import com.tjut.entity.Programme;

import java.util.ArrayList;
import java.util.List;

public class ProgrammeList {
    private List<Programme> ProgramResults = new ArrayList<>();

    public ProgrammeList() {
    }

    public ProgrammeList(List<Programme> programResults) {
        ProgramResults = programResults;
    }

    public List<Programme> getProgramResults() {
        return ProgramResults;
    }

    public void setProgramResults(List<Programme> programResults) {
        ProgramResults = programResults;
    }
}
