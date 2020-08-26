package com.market.card.service.deps;

import com.market.product.service.domain.Product;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @Author: apple
 * @created on 24/08/2020
 * @Project is online-management-system
 */
public class ProductServiceRestClient {

    private final RestTemplate http;

    private final String baseUrl;

    public ProductServiceRestClient(RestTemplate http, String baseUrl) {
        this.http = http;
        this.baseUrl = baseUrl;
    }

    public Product fetchProduct(String productId) {
        return http.getForObject(productUrl(productId), Product.class);
    }

    public URI productUrl(String productId) {
        return URI.create(String.format("%s/products/%s", baseUrl, productId));
    }
}
