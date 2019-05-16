package com.chen.lvyou.controller;

import com.chen.lvyou.entity.LeaveWord;
import com.chen.lvyou.entity.Userinfo;
import com.chen.lvyou.service.ILeavewordService;
import com.chen.lvyou.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author chenhuasheng
 * @description
 * @create 2019/5/16 15:36
 */
@Controller
@RequestMapping("/leaveWord")
public class LeaveWordController {
    @Resource
    private ILeavewordService iLeavewordService;
    @Resource
    private IUserService      iUserService;
    /*前台按照查询条件分页查询留言信息*/
    @RequestMapping(value = { "/frontlist" }, method = { RequestMethod.GET, RequestMethod.POST})
    public String frontlist(Integer pageSize, Integer currentPage, HttpServletRequest request) throws Exception  {
        if (currentPage == null || currentPage == 0) {
            currentPage = 1;
        }
        if (pageSize == null || pageSize == 0) {
            pageSize = 10;
        }
        List<LeaveWord> leaveWordList = iLeavewordService.findAll(1,10);
        List<Userinfo> userInfoList = iUserService.findAllUser(1,10);

        request.setAttribute("leaveWordList",  leaveWordList);
        request.setAttribute("totalPage", 1);
        request.setAttribute("recordNumber", leaveWordList.size());
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("title", leaveWordList.get(0).getTitle());
        request.setAttribute("addTime", leaveWordList.get(0).getAddTime());
        request.setAttribute("userObj", userInfoList.get(0));
        request.setAttribute("userInfoList", userInfoList);
        return "LeaveWord/leaveWord_frontquery_result";
    }
}
