package com.urunov.graphql.customers;

import com.urunov.graphql.orders.Order;

import java.util.List;

/**
 * @Author: apple
 * @created on 02/09/2020
 * @Project is CustomerProject
 */
public class Customer {

    private Long id;
    private String name;
    private String email;
    private List<Order> orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
