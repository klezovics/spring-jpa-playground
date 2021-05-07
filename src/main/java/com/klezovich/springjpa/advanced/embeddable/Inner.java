package com.klezovich.springjpa.advanced.embeddable;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Inner {

    private String innerId;
    private String innerName;
}
