package jx.pgz.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jx.pgz.dao.sys.entity.SysUser;
import jx.pgz.utils.Result;
import jx.pgz.utils.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@Api(tags = "用户管理")
public class SystemController {


    @PostMapping("login")
    @ApiOperation("登录")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        Subject subject = SecurityUtils.getSubject();
        AuthenticationToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/index.html";
    }


    @GetMapping("userInfo")
    @ApiOperation("当前用户信息")
    @ResponseBody
    public Result<SysUser> userInfo() {
        return Result.ok(ShiroUtil.getUser());
    }


}
