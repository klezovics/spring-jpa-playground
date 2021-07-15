package com.klezovich.springjpa.hibernate.manytoone;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    private String comment;

    @ManyToOne
    @JoinColumn(name="fk_book")
    private Book book;
}
