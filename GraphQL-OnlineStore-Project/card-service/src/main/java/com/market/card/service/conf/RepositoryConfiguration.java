package com.market.card.service.conf;

import com.market.card.service.deps.ProductServiceRestClient;
import com.market.card.service.domain.Cart;
import com.market.card.service.domain.CartRespository;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.market.product.service.api.Product;
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
        Product product2 = productServiceRestClient.fetchProduct("59eb83c0040fa80b29938e40");
        Product product3 = productServiceRestClient.fetchProduct("59eb88bd040fa8125aa9c400");

        Cart cart = new Cart();

        cart.addProduct(product1.getId(), product1.getPrice(), 1);
        cart.addProduct(product2.getId(), product2.getPrice(), 2);
        cart.addProduct(product3.getId(), product3.getPrice(), 1);

       cartRespository.save(cart);

    }
}
