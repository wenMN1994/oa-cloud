package com.oa.file;

import com.oa.common.security.annotation.EnableCustomConfig;
import com.oa.common.security.annotation.EnableRyFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import com.oa.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 文件服务
 * 
 * @author ruoyi
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
public class OaFileApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(OaFileApplication.class, args);
    }
}
