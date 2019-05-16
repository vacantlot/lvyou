package com.chen.lvyou.controller;

import com.chen.lvyou.dao.UserinfoDao;
import com.chen.lvyou.entity.Userinfo;
import com.chen.lvyou.service.IUserService;
import com.chen.lvyou.shiro.CustomRealm;
import com.chen.lvyou.vo.ActionResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author chenhuasheng
 * @description
 * @create 2019/4/17 17:46
 */
@Controller
public class LoginController {
    @Resource
    private UserinfoDao         userinfoDao;
    @Resource
    private IUserService        iuserService;
    private final static Logger logger = LoggerFactory.getLogger(CustomRealm.class);

    @RequestMapping(value = "/notLogin", method = RequestMethod.GET)
    public String notLogin() {
        return "您尚未登陆！";
    }

    @RequestMapping(value = "/notRole", method = RequestMethod.GET)
    public String notRole() {
        return "您没有权限！";
    }

    @RequestMapping(value = "/frontlogin", method = RequestMethod.GET)
    public String frontlogin() {
        return "frontlogin";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        // 注销
        subject.logout();
        return "logout";
    }

    /**
     * 登陆
     *
     * @param username 用户名
     * @param password 密码
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ActionResponse login(String username, String password, HttpSession session) {
        return ActionResponse.success(iuserService.login(username, password, session));
    }

    @RequestMapping(value = "/tologin", method = RequestMethod.GET)
    public String backlogin() {
        return "login";
    }

}