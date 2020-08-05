package com.online.graphql.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductNameInput {

    private long id;
    private String name;
    private String slug;
    private String image;
    private String type;
    private String unit;


    private String description;
   // private Date creation_date;




}

