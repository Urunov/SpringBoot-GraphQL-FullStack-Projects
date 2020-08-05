package com.online.graphql.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductInput {

    private String name;
    private String slug;
    private String image;
    private String type;
    private String unit;
    private int price;

    private float salePrice; // nullable=true
    private int disc_in_pros; // default =0
    private int per_unit;  // default =1
    private int quantity; //
    private String description;

    private Date creation_date;
}