package com.chen.lvyou.service;

import javax.servlet.http.HttpSession;

/**
 * @Author chenhuasheng
 * @description
 * @create 2019/4/28 15:16
 */
public interface IAdminService {

    public String adminlogin(String username, String password, HttpSession session);
}
