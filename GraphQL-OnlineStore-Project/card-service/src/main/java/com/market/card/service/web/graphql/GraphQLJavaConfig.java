package com.market.card.service.web.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.market.card.service.domain.Cart;
import com.market.card.service.domain.CartService;
import com.market.card.service.domain.Item;
import com.market.product.service.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;


/**
 * @Author: apple
 * @created on 24/08/2020
 * @Project is online-management-system
 */

@Configuration
public class GraphQLJavaConfig {

    private final CartService cartService;

    private final RestTemplate http;

    @Autowired
    public GraphQLJavaConfig(CartService cartService, RestTemplate http) {
        this.cartService = cartService;
        this.http = http;
    }

    @Bean
    public GraphQLQueryResolver query(){
        return new GraphQLQueryResolver() {
            public String hello() {
                return "Hello, Unicorns.";
            }
            public Cart cart(Long id) {
                return cartService.findCart(id);
            }
        };
    }

    @Bean
    public GraphQLResolver<Item> cartItemResolver(){

        return new GraphQLResolver<Item>() {
            public Product product(Item item) {
                return http.getForObject("http://localhost:9090/products/{id}",
                        Product.class,
                        item.getProductId());
            }
        };
    }

    public GraphQLResolver<Product> productResolver() {
        return new GraphQLResolver<Product>() {
           public List<String> images(Product product, int limit){
               return product.getImages().subList(0, limit>0 ? limit: product.getImages().size());
           }
        };
    }

    public GraphQLMutationResolver mutations(){
        return new GraphQLMutationResolver() {
            public Cart addProductToCart(Long cartId, String productId, int quantity){
                return cartService.addProductToCart(cartId, productId, quantity);
            }
        };
    }
}
