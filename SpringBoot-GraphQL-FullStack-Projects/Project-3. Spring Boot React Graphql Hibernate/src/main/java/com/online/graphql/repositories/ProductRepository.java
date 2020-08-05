package com.online.graphql.repositories;

import com.online.graphql.model.Category;
import com.online.graphql.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

//public interface ProductRepository extends CrudRepository<Product, Long> {


public interface ProductRepository extends JpaRepository<Product, Long> {

//    Optional<Product> findById(Long id);
//    List<Category> findAllByProductId();

}
