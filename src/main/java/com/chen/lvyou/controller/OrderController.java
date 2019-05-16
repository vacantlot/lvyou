package com.chen.lvyou.controller;

import com.chen.lvyou.entity.Orderinfo;
import com.chen.lvyou.entity.Scenic;
import com.chen.lvyou.entity.Userinfo;
import com.chen.lvyou.service.IOrderService;
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
 * @create 2019/5/16 11:08
 */
@Controller
@RequestMapping("/orderInfo")
public class OrderController {

    @Resource
    private IOrderService iOrderService;
    @Resource
    private IScenicService iScenicService;
    @Resource
    private IUserService   iUserService;
    /* 前台按照查询条件分页查询订单信息 */
    @RequestMapping(value = { "/frontlist" }, method = { RequestMethod.GET, RequestMethod.POST })
    public String frontlist(Integer pageSize, Integer currentPage, HttpServletRequest request) throws Exception {
        if (currentPage == null || currentPage == 0) {
            currentPage = 1;
        }
        if (pageSize == null || pageSize == 0) {
            pageSize = 10;
        }
        List<Orderinfo> orderInfoList = iOrderService.findAll(1,10);
        List<Scenic> scenicList = iScenicService.findAll(1, 10);
        List<Userinfo> userInfoList = iUserService.findAllUser(1, 10);
        request.setAttribute("orderInfoList", orderInfoList);
        request.setAttribute("totalPage", 1);
        request.setAttribute("recordNumber", orderInfoList.size());
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("scenicObj", scenicList.get(0));
        request.setAttribute("orderDate", orderInfoList.get(0).getOrderTime());
        request.setAttribute("userObj", userInfoList.get(0));
        request.setAttribute("shState", orderInfoList.get(0).getAuditState());

        request.setAttribute("scenicList", scenicList);

        request.setAttribute("userInfoList", userInfoList);
        return "OrderInfo/orderInfo_frontquery_result";
    }
}
