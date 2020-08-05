package com.online.graphql.repositories;

import com.online.graphql.model.Category;
import com.online.graphql.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @Author: apple
 * @created on 04/08/2020
 * @Project is version1_7_step
 *
 */

public interface OrdersRepository extends JpaRepository<Order, Long> {

//    Optional<Order> findById(Long id);
//    List<Order> findAllByOrderById();
}
