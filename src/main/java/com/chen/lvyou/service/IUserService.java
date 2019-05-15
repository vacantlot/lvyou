package com.chen.lvyou.service;

import com.chen.lvyou.entity.Userinfo;
import org.apache.shiro.authz.annotation.RequiresRoles;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface IUserService {

    int addUser(Userinfo userinfo);

    List<Userinfo> findAllUser(int pageNum, int pageSize);

    String login(String username, String password, HttpSession session);

    Userinfo getUserInfoById(String userId);

    Userinfo findUserByName(String username);
}
