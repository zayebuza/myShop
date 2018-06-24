package com.demo.shopuser.controller;

import com.demo.shopuser.common.BaseResult;
import com.demo.shopuser.common.CommonReturnCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
    /**
     * 用户登录
     * @param loginName
     * @param passWord
     * @return
     * 默认接收明文密码，不进行解密。
     */
    @PostMapping(value="/login")
    @ResponseBody
    public Object login(@RequestParam(value="loginName") String loginName, @RequestParam(value = "passWord") String passWord){

        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginName, passWord);

        currentUser.login(token);
        System.out.println(loginName);
        return new BaseResult(CommonReturnCode.SUCCESS.getCode(),CommonReturnCode.SUCCESS.getMessage());
    }


}
