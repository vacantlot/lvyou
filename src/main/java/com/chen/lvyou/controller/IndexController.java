package com.chen.lvyou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author chenhuasheng
 * @description
 * @create 2019/4/19 17:21
 */
@Controller
public class IndexController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
    @RequestMapping(value = "/window", method = RequestMethod.GET)
    public String window() {
        return "testWindow";
    }

}
