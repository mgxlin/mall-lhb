package com.lhb.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.lhb.mall.mbg.mapper","com.lhb.mall.dao"})
public class MallLhbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallLhbApplication.class, args);
    }

}
