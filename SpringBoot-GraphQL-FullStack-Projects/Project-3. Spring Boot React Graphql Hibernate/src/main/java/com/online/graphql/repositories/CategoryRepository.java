package com.online.graphql.repositories;

import com.online.graphql.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: apple
 * @created on 03/08/2020
 * @Project is version1_7_step
 */

public interface CategoryRepository extends JpaRepository<Category, Long>{


//    Optional<Category> findById(Long id);
//    List<Category> findAllByIdCategory();
}
