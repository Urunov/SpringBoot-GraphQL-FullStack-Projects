package com.market.card.service.domain;

import org.springframework.data.repository.CrudRepository;



/**
 * @Author: apple
 * @created on 24/08/2020
 * @Project is online-management-system
 */
public interface CartRespository extends CrudRepository<Cart, Long> {
    Cart findOne(Long cardId);
}
