//package com.chen.lvyou.controller;
//
//import com.chen.lvyou.entity.City;
//import com.chen.lvyou.entity.Scenic;
//import com.chen.lvyou.entity.ScenicType;
//import com.chen.lvyou.service.ICityService;
//import com.chen.lvyou.service.IScenicService;
//import com.chen.lvyou.service.IScenicTypeService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
//@Controller
//@RequestMapping("/scenic")
//public class ScenicController {
//    @Resource
//    private IScenicService iScenicService;
//
//    @Resource
//    private ICityService   iCityService;
//
//    @Resource
//    private IScenicTypeService iScenicTypeService;
//
//    /* 前台按照查询条件分页查询景点信息 */
//    @RequestMapping(value = { "/frontlist" }, method = { RequestMethod.GET, RequestMethod.POST })
//    public String frontlist(Integer pageSize, Integer currentPage, Model model,
//                            HttpServletRequest request) throws Exception {
//        if (currentPage == null || currentPage == 0) {
//            currentPage = 1;
//        }
//        if (pageSize == null || pageSize == 0) {
//            pageSize = 10;
//        }
//        List<Scenic> scenicList = iScenicService.findAll(1, 10);
//
//        request.setAttribute("scenicList", scenicList);
//        request.setAttribute("totalPage", 1);
//        request.setAttribute("recordNumber", scenicList.size());
//        request.setAttribute("currentPage", currentPage);
//        request.setAttribute("cityObj", scenicList.get(0).getCityId());
//        request.setAttribute("scenicTypeObj", scenicList.get(0).getScenicTypeId());
//        request.setAttribute("dengji", scenicList.get(0).getScenicLevel());
//        request.setAttribute("scenicName", scenicList.get(0).getScenicName());
//
//        List<City> cityList = iCityService.findAll(1,10);
//        request.setAttribute("cityList", cityList);
//        List<ScenicType> scenicTypeList = iScenicTypeService.findAll(1,10);
//        request.setAttribute("scenicTypeList", scenicTypeList);
//        return "Scenic/scenic_frontquery_result";
//    }
//}
