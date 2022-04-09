/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.avantport.cat.service.lib;

import com.avantport.cat.platform.security.annotation.EnableRyFeignClients;
import com.avantport.cat.service.lib.annotation.EnableCustomConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author hongfei
 */
@EnableCustomConfig
@EnableRyFeignClients
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("知识库服务已启动\n");
    }
}
