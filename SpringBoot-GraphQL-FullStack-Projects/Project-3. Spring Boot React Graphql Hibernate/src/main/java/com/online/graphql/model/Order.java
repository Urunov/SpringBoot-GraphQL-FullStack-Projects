package com.online.graphql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author: apple
 * @created on 04/08/2020
 * @Project is version1_7_step
 */
@Data
@Entity
@Table(name = "orders")
public class Order  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float amount;

    private String payment_method;

    private String contact_number;

    private String delivery_address;

    private String status;

    private String description;

    private String discount;

    private int delivery_fee;

    //private Date creation_date;

     @ManyToOne(fetch = FetchType.LAZY)
    //  @JoinColumn(name = "product_id")
     @JsonIgnore
      private Product product;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public int getDelivery_fee() {
        return delivery_fee;
    }

    public void setDelivery_fee(int delivery_fee) {
        this.delivery_fee = delivery_fee;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", amount=" + amount +
                ", payment_method='" + payment_method + '\'' +
                ", contact_number='" + contact_number + '\'' +
                ", delivery_address='" + delivery_address + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", discount='" + discount + '\'' +
                ", delivery_fee=" + delivery_fee +
                '}';
    }

    public Order() {
    }
}
