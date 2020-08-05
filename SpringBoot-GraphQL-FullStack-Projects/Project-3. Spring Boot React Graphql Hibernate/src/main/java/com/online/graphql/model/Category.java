package com.online.graphql.model;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: apple
 * @created on 03/08/2020
 * @Project is version1_7_step
 */
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String value;
    private String type;
    private String icon;
    private String slug;
   // private Date creation_date;


    public Category() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Column(name = "slug")
    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", type='" + type + '\'' +
                ", icon='" + icon + '\'' +
                ", slug='" + slug + '\'' +
                '}';
    }

    /*@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "categories")
    @JoinColumn(name = "product_id")
    private List<Product> products;

     */
}

