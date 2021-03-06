package com.tairanchina.csp.dew.example.tracing;


import com.tairanchina.csp.dew.Dew;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@SpringCloudApplication
@Configuration
public class Tracing2ExampleApplication {

    private Logger logger = LoggerFactory.getLogger(Tracing2ExampleApplication.class);

    public static void main(String[] args) {
        new SpringApplicationBuilder(Tracing2ExampleApplication.class).run(args);
    }

    @PostConstruct
    public void init() {
        logger.info("开始监听..");
        Dew.cluster.mq.subscribe("test", message -> logger.info("pub_sub->{}", message));
    }
}
