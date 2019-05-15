package com.chen.lvyou.controller;

import com.chen.lvyou.entity.ScenicType;
import com.chen.lvyou.service.IScenicTypeService;
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
 * @create 2019/5/13 16:43
 */
@Controller
@RequestMapping("/scenicType")
public class ScenicTypeController {

    @Resource
    private IScenicTypeService iScenicTypeService;
    /*前台按照查询条件分页查询景点分类信息*/
    @RequestMapping(value = { "/frontlist" }, method = { RequestMethod.GET, RequestMethod.POST})
    public String frontlist(Integer pageSize, Integer currentPage, Model model, HttpServletRequest request) throws Exception  {
        if (currentPage==null || currentPage == 0) {
            currentPage = 1;
        }
        if (pageSize == null || pageSize == 0) {
            pageSize = 10;
        }
        List<ScenicType> scenicTypeList = iScenicTypeService.findAll(1,10);

        request.setAttribute("scenicTypeList",  scenicTypeList);
        request.setAttribute("totalPage", 1);
        request.setAttribute("recordNumber", scenicTypeList.size());
        request.setAttribute("currentPage", currentPage);
        return "ScenicType/scenicType_frontquery_result";
    }
}
