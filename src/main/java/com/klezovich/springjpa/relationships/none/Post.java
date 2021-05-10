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

@Entity
public class Post {

    @Id
    @GeneratedValue
    private long id;
    private String text;
}
