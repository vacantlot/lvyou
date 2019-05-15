package com.chen.lvyou;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Author chenhuasheng
 * @description
 * @create 2019/4/18 10:42
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(LvyouApplication.class);
    }
}
