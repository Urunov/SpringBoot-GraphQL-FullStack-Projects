package com.market.card.service.web.graphql.spqr;

import com.market.card.service.domain.Item;
import com.market.product.service.api.Products;
import com.market.product.service.api.Product;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLContext;
import io.leangen.graphql.annotations.GraphQLEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.joining;

/**
 * @Author: apple
 * @created on 24/08/2020
 * @Project is online-management-system
 */

@Component
@Slf4j
public class ProductGraph {

    private final RestTemplate http;

    @Autowired
    public ProductGraph(RestTemplate http) {
        this.http = http;
    }

    public List<Product> products (@GraphQLContext List<Item> items,
                                   @GraphQLEnvironment Set<String> subFields) {
        return http.getForObject(
                "http://localhost:9090/products?ids={id}",
                Products.class,
                items.stream().map(Item::getProductId).collect(joining(",")),
                String.join(",", subFields)
        ).getProducts();
    }

    public List<String> images(@GraphQLContext Product product,
                               @GraphQLArgument(name = "limit", defaultValue = "0") int limit) {
        return product.getImages().subList(
                0, limit > 0 ? limit : product.getImages().size());
    }
}
