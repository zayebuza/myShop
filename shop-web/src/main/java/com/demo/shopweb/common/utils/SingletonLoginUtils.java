package com.demo.shopweb.common.utils;

import com.demo.shopweb.common.shiro.AuthorizingUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 2 * @Author: miaodongbiao
 * 3 * @Date: 2018/6/28 12:34
 * 4   SingletonLoginUtils工具类： 登录用户通用处理工具类
 */
public class SingletonLoginUtils {
    private static final Logger logger = LoggerFactory.getLogger(SingletonLoginUtils.class);




    private SingletonLoginUtils() {
        throw new AssertionError();
    }
    /**
     * 获取登录用户
     * @return
     */
    public static AuthorizingUser getUser() {
        try {
            Subject subject = SecurityUtils.getSubject();
            AuthorizingUser user = (AuthorizingUser) subject.getPrincipal();
            if (user != null) {
                return user;
            }
        } catch (UnavailableSecurityManagerException e) {
            logger.error("SingletonLoginUtils.getUser:{}", e);
        }
        return null;
    }

    /**
     * 获取登录用户ID
     * @return
     */
    public static Long getUserId() {
        try {
            Subject subject = SecurityUtils.getSubject();
            AuthorizingUser user = (AuthorizingUser) subject.getPrincipal();
            if (user != null) {
                return user.getUserId();
            }
        } catch (UnavailableSecurityManagerException e) {
            logger.error("SingletonLoginUtils.getUser:{}", e);
        }
        return null;
    }

}
