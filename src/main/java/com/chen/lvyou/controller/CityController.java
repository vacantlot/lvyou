package com.chen.lvyou.controller;

import com.chen.lvyou.entity.City;
import com.chen.lvyou.service.ICityService;
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
 * @create 2019/5/15 17:34
 */
@Controller
@RequestMapping("/city")
public class CityController {
    @Resource
    private ICityService iCityService;

    /* 前台按照查询条件分页查询城市信息 */
    @RequestMapping(value = { "/frontlist" }, method = { RequestMethod.GET, RequestMethod.POST })
    public String frontlist(Integer pageSize, Integer currentPage, Model model,
                            HttpServletRequest request) throws Exception {
        if (currentPage == null || currentPage == 0) {
            currentPage = 1;
        }
        if (pageSize == null || pageSize == 0) {
            pageSize = 10;
        }
        List<City> cityList = iCityService.findAll(1, 10);

        request.setAttribute("cityList", cityList);
        request.setAttribute("totalPage", 1);
        request.setAttribute("recordNumber", cityList.size());
        request.setAttribute("currentPage", currentPage);
        return "City/city_frontquery_result";
    }
}
