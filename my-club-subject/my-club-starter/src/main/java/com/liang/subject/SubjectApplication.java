package com.liang.subject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * 刷题微服务启动类
 *
 * @author 梁海彪
 * @date 2023/10/19
 */
@SpringBootApplication
@ComponentScan("com.liang")
@MapperScan("com.liang.**.mapper")
public class SubjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubjectApplication.class);
    }
}
