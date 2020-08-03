package com.ohair.stephen.graphql.repositories;

import com.ohair.stephen.graphql.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

//public interface ProductRepository extends CrudRepository<Product, Long> {

public interface ProductRepository extends JpaRepository<Product, Long> {
}
