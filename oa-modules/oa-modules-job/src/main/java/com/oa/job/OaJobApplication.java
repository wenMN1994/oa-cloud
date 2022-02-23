package com.oa.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.oa.common.security.annotation.EnableCustomConfig;
import com.oa.common.security.annotation.EnableRyFeignClients;
import com.oa.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 定时任务
 * 
 * @author ruoyi
 */
@EnableCustomConfig
@EnableCustomSwagger2   
@EnableRyFeignClients
@SpringBootApplication
public class OaJobApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(OaJobApplication.class, args);
    }
}
