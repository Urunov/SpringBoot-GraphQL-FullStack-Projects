package com.urunov.graphql.customers;

import com.urunov.graphql.orders.Order;
import com.urunov.graphql.orders.data.OrderModel;
import com.urunov.graphql.orders.data.OrderRepository;
import com.urunov.graphql.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import graphql.kickstart.tools.GraphQLResolver;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: apple
 * @created on 02/09/2020
 * @Project is CustomerProject
 */
@Component
public class CustomerResolver implements GraphQLResolver<Customer>{

    private OrderRepository orderRepository;

    @Autowired
    public CustomerResolver(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public List<Order> orders(Customer customer) {
        return orderRepository.findByCustomerId(customer.getId())
                .stream()
                .map(this::orderToGraphQL)
                .collect(Collectors.toList());
    }


    private Order orderToGraphQL(OrderModel orderModel){
        Order order = new Order();
           order.setId(orderModel.getId());
           order.setStatus(orderModel.getStatus());
           order.setQuantity(orderModel.getQuantity());
           order.setCreated(orderModel.getCreated());

           Product product = new Product();
           product.setId(orderModel.getProductId());
           order.setProduct(product);

           Customer customer = new Customer();
           customer.setId(orderModel.getCustomerId());
           order.setCustomer(customer);

           return order;
    }

}
