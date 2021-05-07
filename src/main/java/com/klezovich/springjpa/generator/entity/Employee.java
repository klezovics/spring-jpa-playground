package com.klezovich.springjpa.generator.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Employee {

    @Id
    //default value for "strategy" attribute is "GenerationType.AUTO"
    @GeneratedValue
    private Integer id;
    private String name;
}
