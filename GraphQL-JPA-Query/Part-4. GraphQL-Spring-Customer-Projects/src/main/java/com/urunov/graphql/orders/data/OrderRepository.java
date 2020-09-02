package com.urunov.graphql.orders.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @Author: apple
 * @created on 02/09/2020
 * @Project is CustomerProject
 */
public interface OrderRepository extends CrudRepository<OrderModel, Long> {

    List<OrderModel> findByCustomerId(Long customerId);
}
