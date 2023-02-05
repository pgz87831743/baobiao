package jx.pgz.security;


import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {


    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(defaultWebSecurityManager);

        Map<String, String> filterMap = new LinkedHashMap<>();

        //不需要认证的
        filterMap.put("/login", "anon");
        filterMap.put("/doc.html", "anon");
        filterMap.put("/webjars/**", "anon");
        filterMap.put("/swagger-resources", "anon");
        filterMap.put("/v2/api-docs", "anon");
        filterMap.put("/css/**", "anon");
        filterMap.put("/fonts/**", "anon");
        filterMap.put("/img/**", "anon");
        filterMap.put("/js/**", "anon");
        filterMap.put("/favicon.ico", "anon");


        //登出
        filterMap.put("/logout", "logout");

        //要认证的
        filterMap.put("/**", "authc");

        //登录页面
        bean.setLoginUrl("/login.html");

        bean.setFilterChainDefinitionMap(filterMap);


        return bean;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(MyRealm myRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(myRealm);
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(88);
        myRealm.setCredentialsMatcher(matcher);
        return manager;
    }


}
