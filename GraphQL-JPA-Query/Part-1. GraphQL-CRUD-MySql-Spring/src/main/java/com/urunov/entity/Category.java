package com.urunov.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Author: apple
 * @created on 29/08/2020
 * @Project is Crud
 */
@Entity
@Table(name = "category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany()
    private List<Product> product;

}
