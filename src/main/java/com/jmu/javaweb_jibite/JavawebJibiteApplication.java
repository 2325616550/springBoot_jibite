package com.jmu.javaweb_jibite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
@MapperScan(basePackages = "org.sang.mybatis.mapper")
public class JavawebJibiteApplication extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(JavawebJibiteApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JavawebJibiteApplication.class);
    }
}
