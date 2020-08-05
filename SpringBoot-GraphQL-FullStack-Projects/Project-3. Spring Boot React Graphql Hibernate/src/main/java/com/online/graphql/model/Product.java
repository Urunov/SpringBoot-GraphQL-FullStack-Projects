package com.online.graphql.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String slug;
    private String image;
    private String type;
    private String unit;

   // private Category category;

    private int price;

    private float salePrice; // nullable=true
    private int disc_in_pros; // default =0
    private int per_unit;  // default =1
    private int quantity; //
    private String description;
    private Date creation_date;




    /*-----------------------------------*/


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

    @Column(name = "slug")
    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name = "sale_price", nullable = true)
    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    @Column(name = "disc_in_pros")
    public int getDisc_in_pros() {
        return disc_in_pros;
    }

    public void setDisc_in_pros(int disc_in_pros) {
        this.disc_in_pros = disc_in_pros;
    }

    @Column(name = "per_unit")
    public int getPer_unit() {
        return per_unit=1;
    }

    public void setPer_unit(int per_unit) {
        this.per_unit = per_unit;
    }

    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "date")
    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", image='" + image + '\'' +
                ", type='" + type + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
              ", salePrice=" + salePrice +
                ", disc_in_pros=" + disc_in_pros +
                ", per_unit=" + per_unit +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                '}';
    }


   /* @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category categories;



   @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderProducts")
   @JoinColumn(name = "order_id")
   private List<Order> orders = new ArrayList<>();

   */
}
