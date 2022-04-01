package com.mousycoder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * TODO
 *
 * @author mousycoder
 * @version 1.0
 * @date 2022/3/30 9:09 AM
 */
@SpringBootApplication
@MapperScan("com.mousycoder.mapper")
@EnableTransactionManagement
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
