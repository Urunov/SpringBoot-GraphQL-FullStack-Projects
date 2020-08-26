package com.market.product.service.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;
import java.math.BigDecimal;

/**
 * @Author: apple
 * @created on 25/08/2020
 * @Project is online-management-system
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {

    private String id;

    private String title;

    private BigDecimal price;

    private String description;

    private String sku;

    private List<String> images;
}
