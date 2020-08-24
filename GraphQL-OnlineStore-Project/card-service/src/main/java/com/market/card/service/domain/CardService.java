package com.market.card.service.domain;

import com.market.card.service.deps.ProductServiceRestClient;
import domain.Product;
import org.springframework.stereotype.Component;

import javax.smartcardio.Card;

/**
 * @Author: apple
 * @created on 24/08/2020
 * @Project is online-management-system
 */
@Component
public class CardService {

    private final CardRespository cardRespository;

    private final ProductServiceRestClient productServiceRestClient;

    public Card findCard(Long cardId) {
        return cardRespository.findOne(cardId);
    }

    public Card addProductToCard(Long cardId, String productId, int quantity){

        Card card = cardRespository.findOne(cardId);
        Product product = productServiceRestClient.fetchProduct(productId);
        card.addProduct(product.getId(), product.getPrice(), quantity);
        return cardRespository.save(card);
    }
}
