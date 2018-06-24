package com.demo.shopuser.serurity;

import com.demo.shopuser.enums.StatusEnum;
import com.demo.shopuser.entity.User;
import com.demo.shopuser.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by miaodongbiao
 * Date:2018/6/24-13:53
 * Description:
 */
public class ShiroAuthorizingRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
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
        User user = userService.getUserByLoginName(token.getUsername());

        if (user == null || user.getEmailIsActive().equals(StatusEnum.NONACTIVATED.getStatus())){
            throw new UnknownAccountException();// 没找到帐号或者邮箱未被激活
        }
        if (StatusEnum.FREEZE.getStatus().equals(user.getStatus())) {
            throw new DisabledAccountException();// 校验用户状态
        }
        return new SimpleAuthenticationInfo(user,user.getLoginPassword(),this.getClass().getName());
    }
}
