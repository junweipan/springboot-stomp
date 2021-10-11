package com.junwei;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@MapperScan("com.junwei.mapper")
public class SpringbootJunweiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJunweiApplication.class, args);
    }

}
