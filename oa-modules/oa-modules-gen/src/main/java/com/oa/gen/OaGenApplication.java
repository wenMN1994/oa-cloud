package com.oa.gen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.oa.common.security.annotation.EnableCustomConfig;
import com.oa.common.security.annotation.EnableRyFeignClients;
import com.oa.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 代码生成
 * 
 * @author ruoyi
 */
@EnableCustomConfig
@EnableCustomSwagger2   
@EnableRyFeignClients
@SpringBootApplication
public class OaGenApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(OaGenApplication.class, args);
    }
}
