package com.online.graphql.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.online.graphql.exceptions.CategoryNotFoundException;
import com.online.graphql.exceptions.OrderNotFoundException;
import com.online.graphql.exceptions.ProductNotFoundException;
import com.online.graphql.model.Category;
import com.online.graphql.model.Order;
import com.online.graphql.model.Product;
import com.online.graphql.repositories.CategoryRepository;
import com.online.graphql.repositories.OrdersRepository;
import com.online.graphql.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final OrdersRepository ordersRepository;

    /**---------------------------------------------------**/
    public Product product(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("product not found", id));
    }

    public Iterable<Product> allProduct() {

        return productRepository.findAll();
    }


    /** -------------------Category------------------------- */
    public Category category(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("category not found", id));
    }

    public Iterable<Category> allCategory() {
        return categoryRepository.findAll();
    }

    /**-------------------------------------------------------*/

    /** -------------------Order------------------------- */


    public Order order(Long id) {

        return ordersRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("order not found", id));
    }

    public Iterable<Order> allOrders() {
        return ordersRepository.findAll();
    }

    /**-------------------------------------------------------*/

}


