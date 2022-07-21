package com.xkt.valid.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author lzx
 * @date 2022/7/21.
 */
@Data
public class UserNest {
    @NotNull(message = "name不能为空")
    private String name;

    @Min(value = 1, message = "年龄最小为1")
    private Integer age;

    @Valid
    @NotNull(message = "teacher不能为null")
    private Teacher teacher;

    @Valid
    @NotNull(message = "teacher2不能为null")
    private List<Teacher> teacher2;
}
