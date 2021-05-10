package com.klezovich.springjpa.relationships.none;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

//So beautiful and simple when you don't need to setup mappings
@Entity
public class Post {

    @Id
    @GeneratedValue
    private long id;
    private String text;
}
