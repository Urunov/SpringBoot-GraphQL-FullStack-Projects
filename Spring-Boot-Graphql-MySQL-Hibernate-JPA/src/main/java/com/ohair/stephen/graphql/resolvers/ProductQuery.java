package com.ohair.stephen.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.ohair.stephen.graphql.exceptions.ProductNotFoundException;
import com.ohair.stephen.graphql.model.Product;
import com.ohair.stephen.graphql.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductQuery implements GraphQLQueryResolver {

    private final ProductRepository repo;

    public Product product(Long id) {
        return repo.findById(id).orElseThrow(() -> new ProductNotFoundException("product not found", id));
    }

    public Iterable<Product> allProduct() {
        return repo.findAll();
    }

}
