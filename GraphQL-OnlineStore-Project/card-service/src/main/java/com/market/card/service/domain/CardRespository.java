package com.market.card.service.domain;

import org.springframework.data.repository.CrudRepository;

import javax.smartcardio.Card;

/**
 * @Author: apple
 * @created on 24/08/2020
 * @Project is online-management-system
 */
public interface CardRespository extends CrudRepository<Card, Long> {
}
