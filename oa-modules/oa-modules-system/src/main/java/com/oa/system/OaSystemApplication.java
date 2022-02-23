package com.oa.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.oa.common.security.annotation.EnableCustomConfig;
import com.oa.common.security.annotation.EnableRyFeignClients;
import com.oa.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 系统模块
 * 
 * @author ruoyi
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class OaSystemApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(OaSystemApplication.class, args);
    }
}
