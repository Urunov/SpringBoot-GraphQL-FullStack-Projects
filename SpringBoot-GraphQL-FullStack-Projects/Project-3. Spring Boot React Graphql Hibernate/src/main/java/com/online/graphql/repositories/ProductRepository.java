package com.online.graphql.repositories;

import com.online.graphql.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//public interface ProductRepository extends CrudRepository<Product, Long> {

public interface ProductRepository extends JpaRepository<Product, Long> {
}
