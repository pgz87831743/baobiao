package jx.pgz.dao.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;

public class ShiroTest {


    @Test
    void testLogin() {


        //初始化securityManage

        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager manager = factory.getInstance();
        SecurityUtils.setSecurityManager(manager);
        //过去subject 对象
        Subject subject = SecurityUtils.getSubject();
        //创建token对象
        AuthenticationToken authenticationToken = new UsernamePasswordToken("zhangsan", "zs");

        //完成登录对象
        try {
            subject.login(authenticationToken);

            System.out.println(subject.hasRole("user:insert"));
            System.out.println(subject.isPermitted("user:insert"));
            System.out.println(subject.isPermitted("user:insert2"));
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        }


    }


    @Test
    void testMd5() {

        Md5Hash md5Hash = new Md5Hash("123456", "salt", 88);
        System.out.println(md5Hash.toHex());
    }
}
