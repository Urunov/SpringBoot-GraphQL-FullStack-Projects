package com.market.card.service.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.val;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;

/**
 * @Author: apple
 * @created on 24/08/2020
 * @Project is online-management-system
 */

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Column(nullable = false)
    private String productId;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private BigDecimal total;


    public Item(String productId, BigDecimal productPrice, int quantity){
        this.productId = productId;
        this.quantity = quantity;
        val bigDecimal = this.total = BigDecimal.valueOf(quantity).multiply(productPrice);
    }

}
