package com.urunov.wrap.provider;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * @Author: apple
 * @created on 31/08/2020
 * @Project is wrap
 */

@Component
public class GraphQLProvider {

    private GraphQL graphQL;

    @Autowired
    private GraphQLDataFetcher dataFetcher;

    public void init() throws IOException {
        final Resource resource = new ClassPathResource("schema.graphql");
        String sdl = null;

        try {
            sdl = new String(Files.readAllBytes(resource.getFile().toPath()), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(String sdl){
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("websites", dataFetcher.getWebsiteList()))
                .type(TypeRuntimeWiring.newTypeWiring("Query").dataFetcher("website", dataFetcher.getWebsiteById()))
                .type(TypeRuntimeWiring.newTypeWiring("Mutation").dataFetcher("dataFetcher", dataFetcher.addWebsite()))
                .type(TypeRuntimeWiring.newTypeWiring("Mutation").dataFetcher("updateWebsite",
                        dataFetcher.updateWebsite()))
                .type(TypeRuntimeWiring.newTypeWiring("Mutation").dataFetcher("deleteWebsite",
                        dataFetcher.deleteWebsite()))
                .build();

    }

    @Bean
    public GraphQL graphQL(){
        return graphQL;
    }


}
