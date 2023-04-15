package com.tjut.pojo.dto.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramSearchResultList {
    private List<ProgramSearchResult> programSearchResults;
}
