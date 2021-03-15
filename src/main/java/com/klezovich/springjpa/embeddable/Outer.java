package com.klezovich.springjpa.embeddable;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Outer {

    @Id
    @GeneratedValue
    private Long id;
    private String outerName;
    private Inner inner;
}
