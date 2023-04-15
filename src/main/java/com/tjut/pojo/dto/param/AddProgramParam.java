package com.tjut.pojo.dto.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProgramParam {
    private String type;
    private String name;
    private String point;
    private String actors;
}
