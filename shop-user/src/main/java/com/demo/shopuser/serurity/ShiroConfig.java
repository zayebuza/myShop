package com.demo.shopuser.serurity;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by miaodongbiao
 * Date:2018/6/24-15:45
 * Description:
 */
@Configuration
public class ShiroConfig {
    /**
     * 自定义的Realm
     */
    @Bean(name = "myShiroRealm")
    public ShiroAuthorizingRealm myShiroRealm(){
        ShiroAuthorizingRealm myShiroRealm = new ShiroAuthorizingRealm();
        return myShiroRealm;
    }
    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        //设置realm.
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        return shiroFilterFactoryBean;
    }
}
