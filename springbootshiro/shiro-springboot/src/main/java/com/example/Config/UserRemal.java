package com.example.Config;

import com.example.Pojo.User;
import com.example.Service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRemal extends AuthorizingRealm {
    @Autowired
    UserService userService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.print("执行了授权=》doGetAuthorizationInfo方法");
        //SimpleAuthorizationInfo授权方法
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        //info.addStringPermission("user:add");//添加权限
        //拿到当前登录的用户
        Subject subject= SecurityUtils.getSubject();
        User user= (User) subject.getPrincipal();//拿到用户资源
        //设置当前用户的权限
        info.addStringPermission(user.getPerms());
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.print("执行了认证=》doGetAuthorizationInfo方法");
        UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken) token;
        //连接真实的数据库
        User user=userService.QueryUser(usernamePasswordToken.getUsername());
        Subject subject=SecurityUtils.getSubject();
        Session session=subject.getSession();
        session.setAttribute("user",user);
        //1）用户认证
        if (user==null){//无此用户
            return null;//抛出位置用户名的异常
        }
        //SimpleAuthenticationInfo:认证方法
        //密码认证，shiro去做 加密了  SimpleAccount：简单用户  SimpleAuthenticationInfo：用户认证
        /**
         * 传入用户后才可以获取
         * 参数：当前的用户资源、数据库中查询出的密码、盐值、当前realm的名字。
         *  ByteSource.Util.bytes(user.getName()):盐值生成
         */
        SimpleAuthenticationInfo info=null;//MD5加密：new SimpleAuthenticationInfo(user,getMD5Hash(user.getPassword()),"");
        //MD5盐值加密
        //盐
        ByteSource byteSource=ByteSource.Util.bytes(user.getUsername());//盐最好是唯一的字符串
        info=new SimpleAuthenticationInfo(user,getMD5Hash(user.getPassword(),user.getUsername()),byteSource,"");
        return info;
    }

    /**
     * 密码加密时将数据库密码转换为相应的形式
     * 1.MD5
     * 2.MD5盐值加密
     */
    public Object getMD5Hash(Object passwprd){
        String hashAlgorithmName="MD5";
        Object credentials=passwprd;
        Object salt=null;
        int hashIterations=1024;
        Object result=new SimpleHash(hashAlgorithmName,credentials,salt,hashIterations);
       // System.out.println(result);
        return result;
    }
    public Object getMD5Hash(Object passwprd,Object Salt){
        String hashAlgorithmName="MD5";
        Object credentials=passwprd;
        Object salt=ByteSource.Util.bytes(Salt);
        int hashIterations=1024;
        Object result=new SimpleHash(hashAlgorithmName,credentials,salt,hashIterations);
        // System.out.println(result);
        return result;
    }
}
