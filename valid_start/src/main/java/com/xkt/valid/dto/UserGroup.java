package com.xkt.valid.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author lzx
 * @date 2022/7/21.
 */
@Data
public class UserGroup {

    public interface GroupA {
    }

    public interface GroupB {
    }

    @NotNull(message = "name不能为空", groups = GroupA.class)
    private String name;

    @Min(value = 1, message = "年龄最小为1", groups = GroupB.class)
    @NotNull
    private Integer age;
}
