package com.chen.lvyou.controller;

import com.chen.lvyou.entity.Comment;
import com.chen.lvyou.entity.Scenic;
import com.chen.lvyou.entity.Userinfo;
import com.chen.lvyou.service.ICityService;
import com.chen.lvyou.service.ICommentService;
import com.chen.lvyou.service.IScenicService;
import com.chen.lvyou.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author chenhuasheng
 * @description
 * @create 2019/5/16 10:26
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private ICommentService iCommentService;
    @Resource
    private IScenicService  iScenicService;
    @Resource
    private IUserService    iUserService;

    /* 前台按照查询条件分页查询评论信息 */
    @RequestMapping(value = { "/frontlist" }, method = { RequestMethod.GET, RequestMethod.POST })
    public String frontlist(Integer pageSize, Integer currentPage, HttpServletRequest request) throws Exception {
        if (currentPage == null || currentPage == 0) {
            currentPage = 1;
        }
        if (pageSize == null || pageSize == 0) {
            pageSize = 10;
        }
        List<Comment> commentList = iCommentService.findAll(1, 10);
        List<Scenic> scenicList = iScenicService.findAll(1, 10);
        List<Userinfo> userInfoList = iUserService.findAllUser(1, 10);
        // todo 完成查询
        request.setAttribute("commentList", commentList);
        request.setAttribute("totalPage", 1);
        request.setAttribute("recordNumber", commentList.size());
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("scenicObj", scenicList.get(0));
        request.setAttribute("commentContent", commentList.get(0).getCommentcontent());
        request.setAttribute("userObj", userInfoList.get(0));
        request.setAttribute("commentTime", commentList.get(0).getCommentTime());

        request.setAttribute("scenicList", scenicList);

        request.setAttribute("userInfoList", userInfoList);
        return "Comment/comment_frontquery_result";
    }
}
