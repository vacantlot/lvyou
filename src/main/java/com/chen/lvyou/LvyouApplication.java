package com.chen.lvyou;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chen.lvyou.dao")
public class LvyouApplication {

    public static void main(String[] args) {
        SpringApplication.run(LvyouApplication.class, args);
    }

}
