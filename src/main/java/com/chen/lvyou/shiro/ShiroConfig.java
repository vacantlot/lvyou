package com.chen.lvyou.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;
import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author chenhuasheng
 * @description
 * @create 2019/4/17 15:38
 */
@Configuration
public class ShiroConfig {
    private final static Logger logger = LoggerFactory.getLogger(ShiroConfig.class);
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // setLoginUrl 如果不设置值，默认会自动寻找Web工程根目录下的"/login.jsp"页面 或 "/login" 映射
        shiroFilterFactoryBean.setLoginUrl("/frontlogin");
        // 设置无权限时跳转的 url;
        shiroFilterFactoryBean.setUnauthorizedUrl("/error");

        // 设置拦截器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 游客，开放权限
        filterChainDefinitionMap.put("/guest/**", "anon");
        //开放注册入口
        filterChainDefinitionMap.put("/user/add", "anon");
        // 用户，需要角色权限 “user”
        filterChainDefinitionMap.put("/user/**", "roles[user]");
        // 管理员，需要角色权限 “admin”
        filterChainDefinitionMap.put("/admin/**", "roles[admin]");
        // 开放登陆接口
        filterChainDefinitionMap.put("/login", "anon");
        filterChainDefinitionMap.put("/tologin", "anon");
        filterChainDefinitionMap.put("/mainlogin", "anon");


        //开放主页
        filterChainDefinitionMap.put("/index","anon");
        //开发静态资源
        filterChainDefinitionMap.put("/css","anon");
        filterChainDefinitionMap.put("/easyui/**","anon");
        filterChainDefinitionMap.put("/fonts/**","anon");
        filterChainDefinitionMap.put("/images/**","anon");
        filterChainDefinitionMap.put("/js/**","anon");
        filterChainDefinitionMap.put("/plugins/**","anon");
        // 其余接口一律拦截
        // 主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        logger.info("Shiro拦截器工厂类注入成功");
        shiroFilterFactoryBean.setSuccessUrl("/index/**");
        return shiroFilterFactoryBean;

    }

    /**
     * 注入securityManager
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(customRealm());
        return securityManager;
    }

    /**
     * 自定义身份认证 realm; <p> 必须写这个类，并加上 @Bean 注解，目的是注入 CustomRealm， 否则会影响 CustomRealm类 中其他类的依赖注入
     */
    @Bean
    public CustomRealm customRealm() {
        return new CustomRealm();
    }

}
