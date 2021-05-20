package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuxiansong
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.demo.domain.mapper"})
public class DemoClickHouse {

    //查看资料 https://blog.csdn.net/cicada_smile/article/details/102327854

    public static void main(String[] args) {
        SpringApplication.run(DemoClickHouse.class, args);
    }


}
