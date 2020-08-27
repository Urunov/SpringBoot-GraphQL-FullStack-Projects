package com.market.card.service.domain;

import com.market.card.service.deps.ProductServiceRestClient;
import com.market.product.service.api.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: apple
 * @created on 24/08/2020
 * @Project is online-management-system
 */
@Component
public class CartService {

    private final CartRespository cartRespository;

    private final ProductServiceRestClient productServiceRestClient;

    @Autowired
    public CartService(CartRespository cartRespository, ProductServiceRestClient productServiceRestClient) {
        this.cartRespository = cartRespository;
        this.productServiceRestClient = productServiceRestClient;
    }

    public Cart findCart(Long cardId) {

        return cartRespository.findOne(cardId);
    }

    public Cart addProductToCart(Long cartId, String productId, int quantity){

        Cart card = cartRespository.findOne(cartId);
        Product product = productServiceRestClient.fetchProduct(productId);
        card.addProduct(product.getId(), product.getPrice(), quantity);

        return cartRespository.save(card);
    }
}
