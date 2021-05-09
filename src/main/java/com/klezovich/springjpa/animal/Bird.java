package com.klezovich.springjpa.animal;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Getter
@Setter

@Entity
//@DiscriminatorValue("bird") // not necessary for table per class strategy
@PrimaryKeyJoinColumn(name="id")
public class Bird extends Animal {

    private int flightDistanceInKm;
}
