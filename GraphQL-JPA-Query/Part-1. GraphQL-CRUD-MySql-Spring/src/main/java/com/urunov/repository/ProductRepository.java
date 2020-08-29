package com.urunov.repository;

import com.urunov.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: apple
 * @created on 29/08/2020
 * @Project is Crud
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
