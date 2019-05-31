package com.liu.shiro;

import com.liu.entity.AdminUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/*自定义Realm类*/

public class UserRealm extends AuthorizingRealm {



    /*执行授权逻辑*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("这是Realm的授权逻辑");
        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        AdminUser adminUser = (AdminUser) subject.getPrincipal();
        //查询用户权限
//        List<Grade> gradeList = gradeService.selectAdminUserGarde(adminUser);
        //添加资源授权字符串
//        info.addStringPermission(String.valueOf(gradeList.get(0).getId()));
        return info;
    }

    /*执行认证逻辑*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("这是Realm的认证逻辑");
        //获取传递过来的用户名和密码
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        System.out.println(token.getUsername());

        AdminUser adminUser = new AdminUser();
        adminUser.setUsername(token.getUsername());

        //查询数据库用户和密码
//        List<AdminUser> adminUserList = adminUserService.selectByPrimaryKey(adminUser);
//        System.out.println(adminUserList.size());
//        if (adminUserList.size()==0){
//            return null;
//        }

        //2.判断密码（直接new认证逻辑（AuthenticationInfo）的子类）
        return new SimpleAuthenticationInfo("","","");
    }
}
