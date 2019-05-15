package com.chen.lvyou.shiro;

import com.chen.lvyou.dao.UserinfoDao;
import com.chen.lvyou.entity.Userinfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author chenhuasheng
 * @description
 * @create 2019/4/17 16:01
 */
public class CustomRealm extends AuthorizingRealm {
    @Resource
    private              UserinfoDao userinfoDao;
    private final static Logger      logger = LoggerFactory.getLogger(CustomRealm.class);

    @Autowired(required = false)
    public void setUserinfoMapper(UserinfoDao userinfoDao) {
        this.userinfoDao = userinfoDao;
    }

    /**
     * 获取身份验证信息 Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
     *
     * @param authenticationToken 用户身份信息 token
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.debug("————身份认证方法————");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 从数据库获取对应用户名密码的用户
        Userinfo userinfo = new Userinfo();

        userinfo = userinfoDao.findByUsername(token.getUsername());
        if (userinfo == null){
            throw new AccountException("查无此用户");
        }
        String password = userinfo.getPassword();
        // logger.info(new String((char[]) token.getCredentials()));
        // logger.info("token.getPassword()的值:"+new String((char[])token.getPassword()));
        // String[] strs = new String((char[])token.getPassword()).split(",");
        // String psd = strs[1];
        // logger.info("token.getPassword()的值:"+psd);

        //logger.info("登录的用户名为：" + userinfo.getName() + "  密码：" + userinfo.getPassword());
        logger.info("登录的用户名为：" + userinfo.getName());
        if (null == password) {
            throw new AccountException("用户名不正确");
        } else if (!password.equals(new String((char[]) token.getPassword()))) {
            throw new AccountException("密码不正确");
        }
        logger.info("登录成功！");
        return new SimpleAuthenticationInfo(token.getPrincipal(), password, userinfo.getName());

    }

    /**
     * 获取授权信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.debug("————权限认证————");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        // 获得该用户角色
        Userinfo userinfo = new Userinfo();
        logger.debug((userinfoDao.findByUsername(username)).toString());
        userinfo = userinfoDao.findByUsername(username);
        String role = userinfo.getRole();
        Set<String> set = new HashSet<>();
        // 需要将 role 封装到 Set 作为 info.setRoles() 的参数
        set.add(role);
        // 设置该用户拥有的角色
        info.setRoles(set);
        return info;
    }
}
