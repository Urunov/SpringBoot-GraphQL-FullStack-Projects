package com.ohair.stephen.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.ohair.stephen.graphql.exceptions.InvalidArgumentException;
import com.ohair.stephen.graphql.exceptions.ProductNotFoundException;
import com.ohair.stephen.graphql.inputs.CreateProductInput;
import com.ohair.stephen.graphql.inputs.UpdateNameInput;
import com.ohair.stephen.graphql.inputs.UpdatePriceInput;
import com.ohair.stephen.graphql.model.Product;
import com.ohair.stephen.graphql.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ProductMutator implements GraphQLMutationResolver {

    private final ProductRepository repo;

    public Product createProduct(CreateProductInput input) {
        Product product = new Product();
        product.setName(input.getName());
        product.setSlug(input.getSlug());
        product.setPrice(input.getPrice());
        product.setType(input.getType());
        product.setUnit(input.getUnit());


        return repo.save(product);
    }

    public boolean deleteProduct(Long id) {
        repo.deleteById(id);
        return true;
    }

    public Product updateName(UpdateNameInput i) {


        Product p = repo.findById(i.getId())
                .orElseThrow(() -> new ProductNotFoundException("product to update not found", i.getId()));

        Optional.ofNullable(i.getName())
                .orElseThrow(() -> new InvalidArgumentException("name cannot be null", i.getName()));

        Optional.ofNullable(i.getSlug())
                .orElseThrow(() -> new InvalidArgumentException("slug cannot be null", i.getSlug()));

        Optional.ofNullable(i.getType())
                .orElseThrow(()-> new InvalidArgumentException("type cannot be null", i.getType()));

        Optional.ofNullable(i.getUnit())
                .orElseThrow(()-> new InvalidArgumentException("unit cannot be null", i.getUnit()));


        return repo.save(p);
    }


    public Product updatePrice(UpdatePriceInput input){

        Product p = repo.findById(input.getId())
                .orElseThrow(() -> new ProductNotFoundException("product to update not found ", input.getId()));


        return repo.save(p);
    }

}
