package com.chen.lvyou.controller;

import com.chen.lvyou.entity.Admin;
import com.chen.lvyou.service.IAdminService;
import com.chen.lvyou.vo.ActionResponse;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author chenhuasheng
 * @description
 * @create 2019/4/17 17:44
 */
@Controller
public class AdminController {

    @Resource
    private IAdminService iAdminService;

    @RequestMapping(value = "/mainlogin", method = RequestMethod.POST)
    @ResponseBody
    public ActionResponse mainlogin(String username, String password, HttpSession session) {
        return ActionResponse.success(iAdminService.adminlogin(username, password, session));
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String getMain(HttpSession session) {
        return "main";
    }
}
