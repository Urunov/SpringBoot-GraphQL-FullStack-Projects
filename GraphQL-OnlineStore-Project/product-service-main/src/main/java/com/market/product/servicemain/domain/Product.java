package com.market.product.servicemain.domain;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: apple
 * @created on 26/08/2020
 * @Project is online-management-system
 */

@Data
@Document
@RequiredArgsConstructor
public class Product {

    private final String id;

    private final String title;

    private final BigDecimal price;

    private final String description;

    private final String sku;

    private final List<String> images;
}
