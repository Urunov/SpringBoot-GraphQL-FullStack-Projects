package com.market.card.service.web.graphql.spqr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: apple
 * @created on 24/08/2020
 * @Project is online-management-system
 */
@RestController
public class GraphQLController {

    private final GraphQL graphQL;

    @Autowired
    public GraphQLController(CardGraph cardGraph, ProductGraph productQuery){
        GraphQLSchema schema = new GraphQLSchemaGenerator()
                .withResoleverBuilders(
                        new BeanResolverBuilder("")
                )
    }
}
