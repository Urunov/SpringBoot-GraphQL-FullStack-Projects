package com.market.card.service.conf;

import com.market.card.service.deps.ProductServiceRestClient;
import com.market.card.service.domain.CartRespository;
import com.market.product.service.domain.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: apple
 * @created on 24/08/2020
 * @Project is online-management-system
 */

@Configuration
public class RepositoryConfiguration {

    @Bean
    public CommandLineRunner commandLineRunner(CartRespository cartRespository,
                                               ProductServiceRestClient productServiceRestClient) {
        return ($) -> insertInitialData(cartRespository, productServiceRestClient);
    }

    private static void insertInitialData(CartRespository cartRespository, ProductServiceRestClient productServiceRestClient) {

        Product product1 = productServiceRestClient.fetchProduct("59eb83c0040fa80b29938e3f");


    }
}
