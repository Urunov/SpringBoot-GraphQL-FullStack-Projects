package com.urunov.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.urunov.entity.Category;
import com.urunov.entity.Product;
import com.urunov.repository.CategoryRepository;
import com.urunov.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: apple
 * @created on 29/08/2020
 * @Project is Crud
 */
@Component
public class MutationResolver implements GraphQLMutationResolver {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public Category addCategory(String name) {

        Category category = new Category();
        category.setName(name);

        return categoryRepository.saveAndFlush(category);
    }

    public Product addProduct(String name, String code, Double price, Integer category_id) {
        Category category = categoryRepository.findById(category_id).orElseGet(null);

        Product product = new Product();
        product.setId(category_id);
        product.setCode(code);
        product.setPrice(price);
        product.setCategory(category);

        return productRepository.saveAndFlush(product);
    }

    public Category updateCategory(Integer id, String name){
        Category category = new Category();
        category.setId(id);
        category.setName(name);

        return categoryRepository.saveAndFlush(category);
    }

    public Product updateProduct(Integer id, String name, String code, Double price, Integer category_id){
        Category category = categoryRepository.findById(category_id).orElseGet(null);

        Product product = new Product();
        product.setId(category_id);
        product.setCode(code);
        product.setPrice(price);
        product.setCategory(category);

        return productRepository.saveAndFlush(product);
    }

    public Boolean deleteCategory(Integer id){
        categoryRepository.deleteById(id);
        return true;
    }

    public Boolean deleteProduct(Integer id){
       productRepository.deleteById(id);
        return true;
    }

}
