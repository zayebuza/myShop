package com.demo.shopuser.service;

import com.demo.shopuser.common.CommonReturnCode;
import com.demo.shopuser.common.PasswordUtils;
import com.demo.shopuser.common.UserUtils;
import com.demo.shopuser.enums.StatusEnum;
import com.demo.shopuser.common.ValidateException;
import com.demo.shopuser.entity.User;
import com.demo.shopuser.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by miaodongbiao
 * Date:2018/6/24-13:57
 * Description:
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User getUserByLoginName(String username) {
        return userMapper.getUserByLoginName(username);
    }


    public Integer insertUser(User user) {
        User queryUser = new User();
        queryUser.setEmail(user.getEmail());
        User emailUser = userMapper.getUserByLoginName(user.getEmail());
        if (emailUser!=null && StatusEnum.ACTIVATED.getStatus().equals(emailUser.getEmailIsActive())){
            throw new ValidateException(CommonReturnCode.BAD_REQUEST.getCode(),"该邮箱已经被注册了");
        }

        if (emailUser!=null && StatusEnum.NONACTIVATED.getStatus().equals(emailUser.getEmailIsActive())){
            // 如果未被激活则删除用户
            userMapper.deleteById(emailUser.getUserId());
        }
        user.setUserNumber(UserUtils.getUserNumber());
        user.setSalt(PasswordUtils.getSalt());
        user.setPicImg(UserUtils.getPicImg());
        user.setRegeistTime(new Date());
        user.setCreateBy(user.getUserName());
        user.setLoginPassword(PasswordUtils.getMd5(user.getLoginPassword(), user.getUserNumber(), user.getSalt()));
        return userMapper.insert(user);

    }
}
