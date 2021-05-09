package com.klezovich.springjpa.animal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Embeddable
public class DogParentInfo {

    private String motherName;
    private String fatherName;
}
