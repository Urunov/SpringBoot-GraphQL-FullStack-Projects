package com.market.card.service.web.graphql.spqr;

import com.market.card.service.domain.CardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.smartcardio.Card;

/**
 * @Author: apple
 * @created on 24/08/2020
 * @Project is online-management-system
 */
@Component
@Slf4j
public class CardGraph {

    private final CardService cardService;


    public CardGraph(CardService cardService) {
        this.cardService = cardService;
    }

    @GraphQLQuery(name="card")
    public Card card(@GraphQLArgument(name="id") Long id) {
        log.info("fetching card with id={}", id);
        return cardService.findCard(id);
    }

    public Card addProductToCard(@GraphQLArgument(name="cardId") Long cardId,
                                 @GraphQLArgument(name="productId") String productId,
                                 @GraphQLArgument(name="quantity", defaultValue="1") int quantity) {

        log.info("adding {} product(s) with id={} to card with id={}", quantity, productId, cardId);
        return cardService.addProductToCard(cardId, productId, quantity);
    }
}
