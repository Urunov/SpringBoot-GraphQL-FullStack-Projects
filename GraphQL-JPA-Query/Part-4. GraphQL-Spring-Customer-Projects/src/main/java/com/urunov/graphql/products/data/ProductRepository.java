package com.urunov.graphql.products.data;

import org.springframework.data.repository.CrudRepository;

/**
 * @Author: apple
 * @created on 02/09/2020
 * @Project is CustomerProject
 */
public interface ProductRepository extends CrudRepository<ProductModel, Long> {
}
