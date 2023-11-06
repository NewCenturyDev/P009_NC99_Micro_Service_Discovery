package com.newcentury99.p009_nc99_micro_service_discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class P009Nc99MicroServiceDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(P009Nc99MicroServiceDiscoveryApplication.class, args);
    }

}
