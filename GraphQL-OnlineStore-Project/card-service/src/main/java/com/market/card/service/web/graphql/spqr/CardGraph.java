package com.market.card.service.web.graphql.spqr;

import com.market.card.service.domain.Cart;
import com.market.card.service.domain.CartService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * @Author: apple
 * @created on 24/08/2020
 * @Project is online-management-system
 */
@Component
@Slf4j
public class CardGraph {

    private final CartService cartService;


    public CardGraph(CartService cartService) {
        this.cartService = cartService;
    }

    @GraphQLQuery(name="card")
    public Cart cart(@GraphQLArgument(name="id") Long id) {
        log.info("fetching card with id={}", id);
        return cartService.findCart(id);
    }

    public Cart addProductToCart(@GraphQLArgument(name = "cartId") Long cartId,
                                 @GraphQLArgument(name = "productId") String productId,
                                 @GraphQLArgument(name = "quantity", defaultValue = "1")  int quantity) {
        log.info("adding {} product(s) with id={} to cart with id={}", quantity, productId, cartId);
        return cartService.addProductToCart(cartId, productId, quantity);
    }

}
