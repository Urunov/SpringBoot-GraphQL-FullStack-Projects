package com.urunov.graphql.orders.data;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @Author: apple
 * @created on 02/09/2020
 * @Project is CustomerProject
 */

@Entity
@Table(name="orders")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;

    private Long productId;

    private Integer quantity;

    private String status;


    private LocalDate created;


    @Override
    public boolean equals(Object obj) {

        if(this==obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        OrderModel that = (OrderModel) obj;
        return Objects.equals(id, this.id) &&
                Objects.equals(customerId, that.customerId) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(quantity, this.quantity) &&
                Objects.equals(status, this.status) &&
                Objects.equals(created, that.created);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, productId, quantity, status, created);
    }

    @Override
    public String toString() {
        return "OrderModel{" +
                ", id" + id +
                ", productId=" + productId +
                ", customerId=" + customerId +
                ", quantity=" + quantity +
                ", status=" + status +
                ", created = " + created +
                '}';
    }
}
