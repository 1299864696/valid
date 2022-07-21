package com.xkt.valid.controller;

import com.xkt.valid.dto.User;
import com.xkt.valid.dto.UserGroup;
import com.xkt.valid.dto.UserNest;
import com.xkt.valid.validator.ListValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private ListValidator validator;
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

    /**
     * 嵌套List校验
     *
     * 注意 若这里嵌套在controller入口处为List则需要在整个controller上加@Validated才生效
     *
     * @param user
     * @return
     */
    @PostMapping("/nestList2")
    public String nestListSave2(@RequestBody @Validated List<User> user) {
        return "OK";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        if(binder.getTarget() instanceof List) {
            binder.addValidators(validator);
        }
    }

    @PostMapping("/userGroup")
    public String userGroup(@RequestBody @Validated(UserGroup.GroupA.class) UserGroup userGroup) {
        return "OK";
    }
}
