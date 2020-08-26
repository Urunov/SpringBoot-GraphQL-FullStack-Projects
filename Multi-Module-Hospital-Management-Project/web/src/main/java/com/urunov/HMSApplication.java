package com.urunov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Author: apple
 * @created on 25/08/2020
 * @Project is hospital-management-system
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.urunov.*"})
@EnableJpaRepositories(basePackages = {"com.urunov.*"})
@ComponentScan(basePackages = {"com.urunov.*"})

public class HMSApplication {

    public static void main(String[] args) {
        SpringApplication.run(HMSApplication.class);
    }

}
