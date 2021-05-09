package com.klezovich.springjpa.animal;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter

@Entity
//@Inheritance // SINGLE_TABLE is the default strategy
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.JOINED)

//@DiscriminatorColumn(name="animal_type")
//@DiscriminatorValue("animal")
public class Animal {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int age;
}
