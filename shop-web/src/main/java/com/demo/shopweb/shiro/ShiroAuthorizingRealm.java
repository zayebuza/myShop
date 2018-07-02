package com.demo.shopweb.shiro;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.demo.shopdubboapi.entity.user.User;
import com.demo.shopdubboapi.service.user.UserService;
import com.demo.shopuser.enums.StatusEnum;
import com.demo.shopweb.redis.RedisUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.UUID;


/**
 * Created by miaodongbiao
 * Date:2018/6/24-13:53
 * Description:
 */
public class ShiroAuthorizingRealm extends AuthorizingRealm {
    @Reference(application = "${dubbo.application.id}")
    UserService userServiceImpl;

    @Autowired
    RedisTemplate<String,Serializable> redisTemplate;
//    @Autowired
//    RedisUtils redisUtils;

    /**
     * 授权  访问控制。比如某个用户是否具有某个操作的使用权限
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证   用户身份识别，通常被称为用户“登录
     * 认证回调函数, 登录时调用
     * Shiro登录认证(原理：用户提交 用户名和密码  --- shiro 封装令牌 ---- realm 通过用户名将密码查询返回
     *      ---- shiro 自动去比较查询出密码和用户输入密码是否一致---- 进行登陆控制
     *      1、检查提交的进行认证的令牌信息
     2、根据令牌信息从数据源(通常为数据库)中获取用户信息
     3、对用户信息进行匹配验证。
     4、验证通过将返回一个封装了用户信息的AuthenticationInfo实例。
     5、验证失败则抛出AuthenticationException异常信息。
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取基于用户名和密码的令牌：实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        System.out.println(token.getUsername());
        User user = userServiceImpl.getUserByLoginName(token.getUsername());

        if (user == null || user.getEmailIsActive().equals(StatusEnum.NONACTIVATED.getStatus())){
            throw new UnknownAccountException();// 没找到帐号或者邮箱未被激活
        }
        if (StatusEnum.FREEZE.getStatus().equals(user.getStatus())) {
            throw new DisabledAccountException();// 校验用户状态
        }
       //生成一个token
        String token2 = UUID.randomUUID().toString();
        System.out.println(token2);

        redisTemplate.opsForValue().set(token2, 2);
        System.out.println("redis值"+redisTemplate.opsForValue().get("35dafbab-fbbb-46ab-a0d8-99782ad72d99"));

        return new SimpleAuthenticationInfo(user,user.getLoginPassword(),this.getClass().getName());
    }

}
