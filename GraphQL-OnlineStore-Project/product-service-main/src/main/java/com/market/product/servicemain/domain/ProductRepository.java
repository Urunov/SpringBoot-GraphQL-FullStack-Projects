package com.market.product.servicemain.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author: apple
 * @created on 26/08/2020
 * @Project is online-management-system
 */

public interface ProductRepository extends CrudRepository<Product, String>{

    List<Product> findAllBy();

    List<Product> findAllByIdIn(String[]ids);
}
