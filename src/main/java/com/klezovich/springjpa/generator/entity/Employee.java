package com.klezovich.springjpa.generator.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Employee {

    @Id
    //default value for "strategy" attribute is "GenerationType.AUTO"
    //@GeneratedValue
    //Try using other strategies and see what happens ;)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.TABLE)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)

    //Try setting the other values and see what happens
    private Integer id;
    private String name;
}
