package com.demo.shopuser.controller;

import com.demo.shopuser.common.BaseResult;
import com.demo.shopuser.common.CommonReturnCode;
import com.demo.shopuser.common.OsResult;
import com.demo.shopuser.common.RegexUtils;
import com.demo.shopuser.entity.User;
import com.demo.shopuser.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by miaodongbiao
 * Date:2018/6/24-13:39
 * Description:用户登录的controller
 */
@Controller
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    UserService userService;
    /**
     * 用户登录
     * @param loginName
     * @param passWord
     * @return
     * 默认接收明文密码，不进行解密。
     */
    @PostMapping(value="/login")
    @ResponseBody
    public Object login(@RequestParam(value = "loginName") String loginName, @RequestParam(value = "passWord") String passWord){

        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginName, passWord);

        currentUser.login(token);
        System.out.println(loginName);
        return new BaseResult(CommonReturnCode.SUCCESS.getCode(),CommonReturnCode.SUCCESS.getMessage());
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping(value="/register")
    @ResponseBody
    public Object register(@ModelAttribute("user") User user){
        //1,用户信息校验
        if (StringUtils.isEmpty(user.getEmail()) || !RegexUtils.isEmail(user.getEmail())){
            return new OsResult(CommonReturnCode.BAD_REQUEST.getCode(),"请输入正确的邮箱");
        }
        if (StringUtils.isEmpty(user.getLoginPassword()) || !RegexUtils.isPassword(user.getLoginPassword())){
            return new OsResult(CommonReturnCode.BAD_REQUEST.getCode(),"密码长度6~20位，其中数字，字母和符号至少包含两种!");
        }
        userService.insertUser(user);
        return null;
    }


}
