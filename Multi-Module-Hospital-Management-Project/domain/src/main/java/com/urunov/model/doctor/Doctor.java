package com.urunov.model.doctor;

/**
 * @Author: apple
 * @created on 25/08/2020
 * @Project is hospital-management-system
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Doctor {

    @Id
    private int id;
    private String name;
    private String specialist;


}
