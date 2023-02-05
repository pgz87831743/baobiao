package jx.pgz.server.impl;

import jx.pgz.dao.sys.entity.SysUser;
import jx.pgz.dao.sys.service.SysUserService;
import jx.pgz.server.SysUserBusinessService;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SysUserBusinessServiceImpl implements SysUserBusinessService {

    private final SysUserService sysUserService;

    @Override
    public SysUser login(String username, String password) {


        return null;
    }
}
