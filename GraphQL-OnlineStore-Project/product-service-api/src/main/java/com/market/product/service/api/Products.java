package com.market.product.service.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: apple
 * @created on 25/08/2020
 * @Project is online-management-system
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Products {

    private List<Product> products;

}
