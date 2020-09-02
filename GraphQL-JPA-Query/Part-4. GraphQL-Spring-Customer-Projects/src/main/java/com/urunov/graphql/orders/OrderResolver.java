package com.urunov.graphql.orders;

import com.urunov.graphql.customers.Customer;
import com.urunov.graphql.customers.data.CustomerModel;
import com.urunov.graphql.customers.data.CustomerRepository;
import com.urunov.graphql.products.Product;
import com.urunov.graphql.products.data.ProductModel;
import com.urunov.graphql.products.data.ProductRepository;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;

/**
 * @Author: apple
 * @created on 02/09/2020
 * @Project is CustomerProject
 */

@Component
public class OrderResolver implements GraphQLResolver<Order> {

        private ProductRepository productRepository;
        private CustomerRepository customerRepository;

        public OrderResolver(ProductRepository productRepository, CustomerRepository customerRepository){
            this.customerRepository = customerRepository;
            this.productRepository = productRepository;
        }

        public Customer customer(Order order){
            return customerRepository.findById(order.getCustomer().getId())
                    .map(this::modelToGraphQL)
                    .orElse(null);
        }

        public Product product(Order order){
            return productRepository.findById(order.getProduct().getId())
                    .map(this::modelToGraphQL)
                    .orElse(null);
        }

        private Product modelToGraphQL(ProductModel productModel){
            Product product = new Product();

            product.setDescription(productModel.getDescription());
            product.setName(productModel.getName());
            product.setId(productModel.getId());
            product.setPrice(productModel.getPrice());
            return product;
        }

        private Customer modelToGraphQL(CustomerModel customerModel){
            Customer customer = new Customer();

            customer.setEmail(customerModel.getEmail());
            customer.setId(customerModel.getId());
            customer.setName(customerModel.getName());

            return customer;
        }
}
