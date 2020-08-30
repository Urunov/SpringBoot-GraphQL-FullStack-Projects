package com.urunov.repository;

import com.urunov.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: apple
 * @created on 29/08/2020
 * @Project is Crud
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
