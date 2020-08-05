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
public class UpdateOrderFeeInput {

    private long id;
    private Float order;
    private int delivery_fee;
}
