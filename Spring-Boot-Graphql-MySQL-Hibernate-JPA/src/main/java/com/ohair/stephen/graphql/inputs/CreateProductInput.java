package com.ohair.stephen.graphql.inputs;

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
    private String type;
    private String unit;
    private int price;



}