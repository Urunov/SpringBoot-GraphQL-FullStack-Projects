package com.urunov.graphql;

import com.urunov.graphql.customers.Customer;
import com.urunov.graphql.customers.data.CustomerModel;
import com.urunov.graphql.customers.data.CustomerRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

/**
 * @Author: apple
 * @created on 02/09/2020
 * @Project is CustomerProject
 */

@Component
public class QueryResolver implements GraphQLQueryResolver {

    private CustomerRepository customerRepository;

    public QueryResolver(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer customerById(Long id){
        return customerRepository
                .findById(id)
                .map(this::modelToGraphQL)
                .orElse(null);
    }

    private Customer modelToGraphQL(CustomerModel customerModel){
        Customer customer = new Customer();
        customer.setId(customerModel.getId());
        customer.setName(customerModel.getName());
        customer.setEmail(customerModel.getEmail());

        return customer;
    }
}
