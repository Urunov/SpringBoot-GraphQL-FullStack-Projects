package com.market.card.service.web.http;

import com.market.card.service.domain.Item;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: apple
 * @created on 24/08/2020
 * @Project is online-management-system
 */
@Data
public class CartWithProductsProjection {

    private Long id;

    private List<Item> items;

    private BigDecimal subTotal;

    @Data
    public static class Item {

        private ProductProjection product;

        private int quantity;

        private BigDecimal total;


        @Data
        public static class ProductProjection {
            private String id;

            private String title;

            private BigDecimal price;

            private String image;

            private String sku;
        }
    }
}
