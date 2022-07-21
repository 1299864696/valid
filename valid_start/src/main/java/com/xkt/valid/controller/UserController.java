package com.xkt.valid.controller;

import com.xkt.valid.dto.User;
import com.xkt.valid.dto.UserGroup;
import com.xkt.valid.dto.UserI18n;
import com.xkt.valid.dto.UserNest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

/**
 * @author lzx
 * @date 2022/7/21.
 */
@RequestMapping("/user")
@RestController
public class UserController {
    /*@Autowired
    private ListValidator listValidator;*/
    @Autowired
    private Validator validator;

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

   /* *//**
     * 嵌套List校验
     *
     * 注意 借助@InitBinder
     *
     *//*

    @PostMapping("/nestList2")
    public String nestListSave2(@RequestBody @Validated List<User> user) {
        return "OK";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        if(binder.getTarget() instanceof List) {
            binder.addValidators(listValidator);
        }
    }*/

    @PostMapping("/userGroup")
    public String userGroup(@RequestBody @Validated(UserGroup.GroupA.class) UserGroup userGroup) {
        return "OK";
    }

    @PostMapping("/manual")
    public String manual(@RequestBody User user) {
        Set<ConstraintViolation<User>> result = validator.validate(user);
        // 打印校验结果
        for (ConstraintViolation<User> constraintViolation : result) {
            // 属性:消息
            System.out.println(constraintViolation.getPropertyPath() + ":" + constraintViolation.getMessage());
        }
        return "OK";
    }

    /**
     *
     * SpringMVC 通过 Accept-Language 请求头，实现 i18n 国际化。
     *
     * 在Header中设置Accept-Language为en/zh/ja
     */
    @PostMapping("/i18n")
    public String i18n(@Validated @RequestBody UserI18n user) {
        return "OK";
    }
}
