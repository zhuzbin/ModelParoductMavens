package com.zhuzb.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Desc：自定义验证规则1
 * User：ZhuZhiBin
 * Date：2017/11/24
 * Time：18:25
 */
public class MyRealm1 implements Realm {
    public String getName() {
        return "myRealm1";
    }

    public boolean supports(AuthenticationToken authenticationToken) {
        //仅支持UsernamePasswordToken
        return authenticationToken instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String)authenticationToken.getPrincipal();
        String password = new String((char[])authenticationToken.getCredentials());
        if(!"zhang".equals(username)){
            throw new UnknownAccountException();//用户名错误
        }
        if(!"123".equals(password)){
            throw new IncorrectCredentialsException();//密码错误
        }

        //如果身份验证成功，返回一个AuthenticationInfo
        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
