package jx.pgz.security;

import jx.pgz.dao.sys.entity.*;
import jx.pgz.dao.sys.service.*;
import jx.pgz.model.RouterVO;
import jx.pgz.utils.ShiroUtil;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyRealm extends AuthorizingRealm {


    private final SysUserService sysUserService;
    private final SysRoleService sysRoleService;
    private final SysPermissionService sysPermissionService;

    private final SysUserRoleService sysUserRoleService;
    private final SysRolePermissionService sysRolePermissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        SysUser user = ShiroUtil.getUser();

        if (user != null) {
            if (user.getRoles() != null) {
                info.setRoles(user.getRoles().stream().map(SysRole::getRoleName).collect(Collectors.toSet()));
            }

            if (user.getPermissions() != null) {
                info.addStringPermissions(user.getPermissions().stream().map(SysPermission::getPermissionName).collect(Collectors.toSet()));
            }
        }

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println(authenticationToken.getPrincipal().toString());
        System.out.println(authenticationToken.getCredentials().toString());

        SysUser user = sysUserService.lambdaQuery()
                .eq(SysUser::getUsername, authenticationToken.getPrincipal().toString())
                .one();
        if (user != null) {

            List<SysUserRole> roles = sysUserRoleService.lambdaQuery().eq(SysUserRole::getUserId, user.getId()).list();
            if (!roles.isEmpty()) {
                List<Long> roleIds = roles.stream().map(SysUserRole::getRoleId).collect(Collectors.toList());
                //设置角色
                user.setRoles(sysRoleService.lambdaQuery().in(SysRole::getId, roleIds).list());
                List<SysRolePermission> rolePermissions = sysRolePermissionService.lambdaQuery().in(SysRolePermission::getRoleId, roleIds)
                        .list();
                if (!rolePermissions.isEmpty()) {
                    List<Long> permissionIds = rolePermissions.stream().map(SysRolePermission::getPermissionId).collect(Collectors.toList());
                    //设置权限
                    user.setPermissions(sysPermissionService.lambdaQuery()
                            .in(SysPermission::getId, permissionIds).list());

                    List<RouterVO> routerVOS = user.getPermissions().stream().filter(s -> "mean".equals(s.getType())).map(s -> {
                        RouterVO routerVO = new RouterVO();
                        routerVO.setPath(s.getUrl());
                        routerVO.setComponent(s.getPermissionName());
                        return routerVO;
                    }).collect(Collectors.toList());
                    user.setRouterVOS(routerVOS);
                }
            }

            return new SimpleAuthenticationInfo(
                    user,
                    user.getPassword(),
                    ByteSource.Util.bytes(user.getSalt()),
                    authenticationToken.getPrincipal().toString()
            );

        }
        return null;
    }


}
