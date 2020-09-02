package com.urunov.graphql.products.data;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author: apple
 * @created on 02/09/2020
 * @Project is CustomerProject
 */

@Entity
@Table(name = "products")
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private Double price;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {

        if(this == obj) return true;
        if(obj==null || getClass() !=obj.getClass()) return false;
        ProductModel productModel = (ProductModel) obj;
        return Objects.equals(id, productModel.id) &&
               Objects.equals(name, productModel.name) &&
               Objects.equals(description, productModel.name) &&
               Objects.equals(price, productModel.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price);
    }


    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
