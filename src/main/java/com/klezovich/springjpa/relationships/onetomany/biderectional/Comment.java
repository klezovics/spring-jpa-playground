package com.klezovich.springjpa.relationships.onetomany.biderectional;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private long id;
    private String text;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post1 post;
}
