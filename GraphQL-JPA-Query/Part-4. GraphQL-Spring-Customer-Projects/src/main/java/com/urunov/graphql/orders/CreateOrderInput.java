package com.urunov.graphql.orders;

import java.util.Objects;

/**
 * @Author: apple
 * @created on 02/09/2020
 * @Project is CustomerProject
 */
public class CreateOrderInput {

    private Long customerId;
    private Long productId;
    private Integer quantity;

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

    public Long getCustomerId(){
        return customerId;
    }

    public void setCustomerId(Long customerId){
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if (obj==null || getClass() != obj.getClass()) return false;
        CreateOrderInput that = (CreateOrderInput) obj;
        return Objects.equals(customerId, that.customerId) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(quantity, that.quantity);
   }


    @Override
    public int hashCode() {
        return Objects.hash(customerId, productId, quantity);
   }
}
