package com.klezovich.springjpa.embeddable;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Inner {

    private String innerId;
    private String innerName;
}
