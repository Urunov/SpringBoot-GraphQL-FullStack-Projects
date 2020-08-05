package com.online.graphql.inputs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: apple
 * @created on 03/08/2020
 * @Project is version1_7_step
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
public class UpdateCategoryNameInput {

    private Long id;
    private String name;
    private String value;
    private String type;
    private String icon;
    private String slug;
}
