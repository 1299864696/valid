package com.xkt.valid.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author lzx
 * @date 2022/7/21.
 */
@Data
public class UserI18n {


    /**
     * 这里使用了占位符 读取配置文件
     */
    @NotBlank(message = "{UserI18n.name.NotBlank}")
    private String name;

}
