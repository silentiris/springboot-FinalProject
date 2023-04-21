package com.tjut.pojo.dto.param;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyProgramParam {
    @Positive(message = "id不能为空")
    private int id;
    @NotBlank(message = "类型不能为空")
    private String type;
    @NotBlank(message = "姓名不能为空")
    private String name;
    @NotNull(message = "看点不能为空")
    private String point;
    @NotBlank(message = "演员名单不能为空")
    private String actors;
}
