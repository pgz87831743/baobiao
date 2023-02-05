package jx.pgz.utils;


import jx.pgz.dao.sys.entity.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class ShiroUtil {


    private static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static SysUser getUser() {
        Object principal = getSubject().getPrincipal();
        if (principal != null) {
            return ((SysUser) principal);
        }
        return null;
    }
}
