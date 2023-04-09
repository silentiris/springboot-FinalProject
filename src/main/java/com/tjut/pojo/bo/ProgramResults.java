package com.tjut.pojo.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProgramResults {
    private int id;
    private String typeName;
    private String name;
    private String view;
    private String actorList;
}
