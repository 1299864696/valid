package com.xkt.valid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lzx
 * @date 2022/7/21.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultDTO {
    private Integer code;
    private String msg;
}
