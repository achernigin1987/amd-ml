package com.amd.ml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
//@EnableAsync
//@EnableScheduling
@EnableAutoConfiguration
//@EnableAspectJAutoProxy(proxyTargetClass=true)
@PropertySource(value = "classpath:/ml-services-app.properties")
@ComponentScan("com.amd.ml.*")
public class MLServicesApp {

    public static void main(String[] args) {
        SpringApplication.run(MLServicesApp.class, args);
    }
}
