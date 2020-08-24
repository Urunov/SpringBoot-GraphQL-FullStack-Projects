package com.market.card.service.domain;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: apple
 * @created on 24/08/2020
 * @Project is online-management-system
 */
@Data
@Entity
@Table
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private List<Item> items = new ArrayList<>();


    public BigDecimal getSubTotal() {
        return getItems().stream()
                .map(Item::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addProduct(String id, BigDecimal price, int quantity){
        Item item = getItems().stream()
                .filter(p-> p.getProductId().equals(id))
                .findFirst()
                .orElseGet(() -> {
                    Item newItem = new Item(id, 0, BigDecimal.ZERO);
                    getItems().add(newItem);
                    return newItem;
                });
        item.setQuantity(item.getQuantity() + quantity);
        item.setTotal(price.multiply(BigDecimal.valueOf(item.getQuantity())));
    }

}
