package com.chen.lvyou.service.impl;

import com.chen.lvyou.entity.Userinfo;
import com.chen.lvyou.service.IUserService;
import com.chen.lvyou.shiro.CustomRealm;
import com.chen.lvyou.vo.RespBasicCode;
import com.github.pagehelper.PageHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.chen.lvyou.dao.UserinfoDao;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserinfoDao         userinfoDao;
    private final static Logger logger = LoggerFactory.getLogger(CustomRealm.class);

    @Override
    public int addUser(Userinfo userinfo) {
        userinfo.setRole("user");
        return userinfoDao.insertSelective(userinfo);
    }

    /**
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper 很简单， 只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可； pageNum 开始页数 pageSize 每页显示的数据条数
     */
    @Override
    public List<Userinfo> findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return userinfoDao.selectAllUser();
    }

    @Override
    public String login(String username, String password, HttpSession session) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        subject.login(token);
        // 获得该用户角色
        Userinfo userinfo = userinfoDao.findByUsername(username);
        String role = userinfo.getRole();

        if ("user".equals(role)) {
            logger.info("欢迎用户：" + userinfo.getName() + "登陆");
            session.setAttribute("user_name", userinfo.getName());
            return "success";
        }

        // Todo
        return RespBasicCode.BUSSINESS_EXCETION.toString();
    }

    @Override
    public Userinfo getUserInfoById(String userId) {
        return userinfoDao.selectByPrimaryKey(userId);
    }

    @Override
    public Userinfo findUserByName(String username) {
        return userinfoDao.findByUsername(username);
    }

}
