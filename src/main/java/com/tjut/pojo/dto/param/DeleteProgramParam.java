package com.tjut.pojo.dto.param;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteProgramParam {
    @Positive(message = "id不能为空")
    private int id;
}
