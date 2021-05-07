package com.klezovich.springjpa.generator.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

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
    //You will notice that in H2 console you will be able to
    //see either an addtional sequence or a table
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.TABLE) // also check out the @TableGenerator annotation
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name="emp_id", strategy = "com.klezovich.springjpa.generator.entity.CustomRandomIDGenerator")
    @GeneratedValue(generator = "emp_id")
    //Try setting the other values and see what happens
    private Integer id;
    private String name;
}
