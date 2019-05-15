package com.chen.lvyou.controller;

import com.chen.lvyou.entity.Userinfo;
import com.chen.lvyou.service.IUserService;
import com.chen.lvyou.shiro.ShiroConfig;
import com.chen.lvyou.vo.ActionResponse;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private              IUserService iuserService;
    private final static Logger       logger = LoggerFactory.getLogger(UserController.class);

    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", method = RequestMethod.GET)
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return iuserService.findAllUser(pageNum, pageSize);
    }

    /**
     * 注册
     * @param userinfo
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ActionResponse addUserInfo(Userinfo userinfo) {
        return ActionResponse.success(iuserService.addUser(userinfo));
    }

    /*跳转到添加UserInfo视图*/
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String userAdd(Model model, HttpServletRequest request) throws Exception {
        logger.debug("调用user/add");
        model.addAttribute(new Userinfo());
        return "UserInfo/userInfo_add";
    }

    /*前台查询UserInfo信息*/
    @RequestMapping(value="/frontshow",method=RequestMethod.GET)
    public String frontshow(Model model,HttpServletRequest request) throws Exception {
        /*根据主键userId获取UserInfo对象*/
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        logger.debug("获取到前台登录用户"+username);
        Userinfo user = iuserService.findUserByName(username);
        //Userinfo userInfo = iuserService.getUserInfo("1");
        request.setAttribute("userinfo",  user);
        return "UserInfo/userInfo_frontshow";
    }

    /*前台按照查询条件分页查询用户信息*/
    @RequestMapping(value = { "/frontlist" }, method = {RequestMethod.GET,RequestMethod.POST})
    public String frontlist(Integer pageSize,Integer currentPage, Model model, HttpServletRequest request) throws Exception  {
        if (currentPage==null || currentPage == 0) currentPage = 1;
        if (pageSize == null || pageSize == 0) pageSize = 10;
        List<Userinfo> userInfoList = iuserService.findAllUser(1,10);

        request.setAttribute("userInfoList",  userInfoList);
        request.setAttribute("totalPage", 1);
        request.setAttribute("recordNumber", userInfoList.size());
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("userId", userInfoList.get(0).getUserId());
        request.setAttribute("name", userInfoList.get(0).getName());
        request.setAttribute("birthday", userInfoList.get(0).getBirthday());
        return "UserInfo/userInfo_frontquery_result";
    }

    /*前台查询UserInfo信息*/
    @RequestMapping(value="/{userId}/frontshow",method=RequestMethod.GET)
    public String frontshow(@PathVariable String userId,Model model,HttpServletRequest request) throws Exception {
        /*根据主键userId获取UserInfo对象*/
        Userinfo userinfo = iuserService.getUserInfoById(userId);
        request.setAttribute("userinfo",  userinfo);
        return "UserInfo/userInfo_frontshow";
    }
}
