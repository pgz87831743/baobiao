package jx.pgz.server;

import jx.pgz.dao.sys.entity.SysUser;

public interface SysUserBusinessService {


    SysUser login(String username, String password);


}
