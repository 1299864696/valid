package com.xkt.valid.controller;

import com.xkt.valid.dto.User;
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

    @PostMapping()
    public String save(@Validated @RequestBody User user) {
        return "OK";
    }
}
