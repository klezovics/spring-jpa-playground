package com.klezovich.springjpa.animal;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Getter
@Setter

@Entity
//@DiscriminatorValue("dog")
@PrimaryKeyJoinColumn(name="id")
public class Dog extends Animal {

    private int barkLoudnessInDb;
    @Embedded
    private DogParentInfo parentInfo;
}
