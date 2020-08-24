package com.market.card.service.conf;

import com.market.card.service.deps.ProductServiceRestClient;
import com.market.card.service.domain.CardRespository;
import domain.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import javax.smartcardio.Card;

/**
 * @Author: apple
 * @created on 24/08/2020
 * @Project is online-management-system
 */

@Configuration
public class RepositoryConfiguration {

    public CommandLineRunner commandLineRunner(CardRespository cardRespository, ProductServiceRestClient productServiceRestClient) {
        return ($) -> insertInitialData(cardRespository, productServiceRestClient);
    }

    private static void insertInitialData(CardRespository cardRespository, ProductServiceRestClient productServiceRestClient) {

        Product product1 = productServiceRestClient.fetchProduct("59eb83c0040fa80b29938e3f");

        Card card = new Card();
        card.addProduct(product1.getId(), product1.getPrice(), 1);
    }
}
