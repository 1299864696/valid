package com.xkt.valid.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author lzx
 * @date 2022/7/21.
 */
@Data
public class Teacher {
    @NotBlank(message = "老师名字不能为空")
    private String name;
}
