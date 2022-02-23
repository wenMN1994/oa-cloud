package com.oa.modules.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import de.codecentric.boot.admin.server.config.EnableAdminServer;

/**
 * 监控中心
 * 
 * @author ruoyi
 */
@EnableAdminServer
@SpringBootApplication
public class OaMonitorApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(OaMonitorApplication.class, args);
    }
}
