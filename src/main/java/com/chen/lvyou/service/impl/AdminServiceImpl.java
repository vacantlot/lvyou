package com.chen.lvyou.service.impl;

import com.chen.lvyou.dao.AdminDao;
import com.chen.lvyou.dao.UserinfoDao;
import com.chen.lvyou.entity.Admin;
import com.chen.lvyou.entity.Userinfo;
import com.chen.lvyou.service.IAdminService;
import com.chen.lvyou.service.IUserService;
import com.chen.lvyou.shiro.CustomRealm;
import com.chen.lvyou.vo.RespBasicCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author chenhuasheng
 * @description
 * @create 2019/4/28 15:18
 */
@Service
public class AdminServiceImpl implements IAdminService {

    @Resource
    private AdminDao            adminDao;
    private final static Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Override
    public String adminlogin(String username, String password, HttpSession session) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        subject.login(token);
        // 获得该用户角色
        Admin admin = adminDao.selectByPrimaryKey(username);

        if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
            logger.info("欢迎管理员：" + admin.getUsername() + "登陆");
            session.setAttribute("username", admin.getUsername());
            return "success";
        }
        // Todo
        return RespBasicCode.BUSSINESS_EXCETION.toString();
    }
}
