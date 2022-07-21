package com.xkt.valid.controller;

import com.xkt.valid.dto.User;
import com.xkt.valid.dto.UserNest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lzx
 * @date 2022/7/21.
 */
@RequestMapping("/user")
@RestController
public class UserController {

    /**
     * 基本校验
     * @param user
     * @return
     */
    @PostMapping()
    public String save(@Validated @RequestBody User user) {
        return "OK";
    }

    /**
     * 嵌套校验
     * @param user
     * @return
     */
    @PostMapping("/nest")
    public String nestSave(@Validated @RequestBody UserNest user) {
        return "OK";
    }
}
