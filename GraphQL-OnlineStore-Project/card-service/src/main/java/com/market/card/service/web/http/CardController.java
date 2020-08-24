package com.market.card.service.web.http;

import com.market.card.service.deps.ProductServiceRestClient;
import com.market.card.service.domain.CardService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: apple
 * @created on 24/08/2020
 * @Project is online-management-system
 */

@RestController
public class CardController {

    private final CardService cardService;

    private final ProductServiceRestClient productServiceRestClient;
}
