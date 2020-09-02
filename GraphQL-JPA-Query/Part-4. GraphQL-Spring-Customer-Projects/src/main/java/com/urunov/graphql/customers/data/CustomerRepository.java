package com.urunov.graphql.customers.data;

/**
 * @Author: apple
 * @created on 02/09/2020
 * @Project is CustomerProject
 */

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerModel, Long> {
}
