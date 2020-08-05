package com.online.graphql.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductPriceInput {


    private long id;
    private int price;

    private float salePrice; // nullable=true
    private int disc_in_pros; // default =0
    private int per_unit;  // default =1
    private int quantity; //
}
