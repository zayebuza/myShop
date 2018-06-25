package com.demo.shopuser.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Druid配置类
 *
 * @author Shanks
 */
@Configuration
public class DruidConfig {


    /**
     * 配置监控服务器
     * @return 返回监控注册的servlet对象
     */
    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean reg = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");

        // 添加控制台管理用户  http://localhost:8080/druid/index.html
        reg.addInitParameter("loginUsername","druid");
        reg.addInitParameter("loginPassword","123456");
        return reg;
    }

    /**
     * 配置服务过滤器
     * @return 返回过滤器配置对象
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filterRegistrationBean.addInitParameter("profileEnable", "true");
        filterRegistrationBean.addInitParameter("principalCookieName","USER_COOKIE");
        filterRegistrationBean.addInitParameter("principalSessionName","USER_SESSION");
        filterRegistrationBean.addInitParameter("DruidWebStatFilter","/*");
        return filterRegistrationBean;
    }
}
