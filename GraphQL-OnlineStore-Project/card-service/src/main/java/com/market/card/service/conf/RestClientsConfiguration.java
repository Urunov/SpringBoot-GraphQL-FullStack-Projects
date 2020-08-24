package com.market.card.service.conf;

import com.market.card.service.deps.ProductServiceRestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: apple
 * @created on 24/08/2020
 * @Project is online-management-system
 */
@Configuration
public class RestClientsConfiguration {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate(new HttpComponentsClientHttpRequestFactory());
    }

    public ProductServiceRestClient productServiceRestClient(){
        return new ProductServiceRestClient(restTemplate(), "http://localhost:9090");
    }
}
