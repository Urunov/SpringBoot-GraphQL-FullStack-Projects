package com.online.graphql.repositories;

import com.online.graphql.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: apple
 * @created on 04/08/2020
 * @Project is version1_7_step
 */
public interface OrdersRepository extends JpaRepository<Order, Long> {
//public interface OrderRepository extends CrudRepository<Order, Long> {
}
