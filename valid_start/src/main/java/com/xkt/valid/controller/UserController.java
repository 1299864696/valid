package com.xkt.valid.controller;

import com.xkt.valid.dto.User;
import com.xkt.valid.dto.UserNest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author lzx
 * @date 2022/7/21.
 */
@Validated
@RequestMapping("/user")
@RestController
public class UserController {

    /**
     * 基本校验
     *
     * @param user
     * @return
     */
    @PostMapping()
    public String save(@Validated @RequestBody User user) {
        return "OK";
    }

    /**
     * 嵌套校验
     *
     * @param user
     * @return
     */
    @PostMapping("/nest")
    public String nestSave(@Validated @RequestBody UserNest user) {
        return "OK";
    }

    /**
     * 嵌套List校验
     *
     * 注意 若这里嵌套在controller入口处为List则需要在整个controller上加@Validated才生效
     *
     * @param user
     * @return
     */
    @PostMapping("/nestList")
    public String nestListSave(@RequestBody List<@Valid User> user) {
        return "OK";
    }
}
