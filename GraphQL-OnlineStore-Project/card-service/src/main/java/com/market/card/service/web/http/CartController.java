package com.market.card.service.web.http;

import com.market.card.service.deps.ProductServiceRestClient;
import com.market.card.service.domain.Cart;
import com.market.card.service.domain.CartService;
import com.market.card.service.domain.Item;
import com.market.product.service.api.Product;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: apple
 * @created on 24/08/2020
 * @Project is online-management-system
 */

@RestController
public class CartController {

    private final CartService cartService;

    private final ProductServiceRestClient productServiceRestClient;

    @Autowired
    public CartController(CartService cartService, ProductServiceRestClient productServiceRestClient) {
        this.cartService = cartService;
        this.productServiceRestClient = productServiceRestClient;
    }

    @RequestMapping("/cards/{id}")
    @ResponseBody
    public Object get(@PathVariable Long id,
                      @RequestParam(value = "projection", required = false) String projection) {
        val cart = cartService.findCart(id);
        if ("with-products".equals(projection)) {
            return getProjectionWithProducts(cart);
        }
        return cart;
    }

    private CartWithProductsProjection getProjectionWithProducts(Cart source) {
        val card = new CartWithProductsProjection();
        card.setId(source.getId());
        card.setItems(toItemsWithProducts(source.getItems()));
        card.setSubTotal(source.getSubTotal());
        return card;
    }

    private List<CartWithProductsProjection.Item> toItemsWithProducts(List<Item> sources){
        return sources.stream().map(sourceItem -> {
            val item = new CartWithProductsProjection.Item();
            item.setProduct(toProductProjection(productServiceRestClient.fetchProduct(sourceItem.getProductId())));
            item.setQuantity(sourceItem.getQuantity());
            item.setTotal(sourceItem.getTotal());
            return item;
        }).collect(Collectors.toList());
    }

    private CartWithProductsProjection.Item.ProductProjection toProductProjection(Product source) {
        val product = new CartWithProductsProjection.Item.ProductProjection();
        product.setId(source.getId());
        product.setTitle(source.getTitle());
        product.setPrice(source.getPrice());
        product.setSku(source.getSku());
        product.setImage(source.getImages().get(0));
        return product;
    }
}
