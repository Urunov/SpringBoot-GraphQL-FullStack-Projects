package com.online.graphql.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: apple
 * @created on 04/08/2020
 * @Project is version1_7_step
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderInput {

    private Float amount;

    private String payment_method;

    private String contact_number;

    private String delivery_address;

    private String status;

    private String description;

    private String discount;

    private int delivery_fee;

}
