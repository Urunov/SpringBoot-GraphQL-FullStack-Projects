package domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.lang.annotation.Documented;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: apple
 * @created on 24/08/2020
 * @Project is online-management-system
 */

@Document
@RequiredArgsConstructor
@Data
public class Product {

    private final String id;

    private final String title;

    private final BigDecimal price;

    private final String description;

    private final String sku;

    private final List<String> images;
}
