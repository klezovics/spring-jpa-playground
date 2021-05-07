package com.klezovich.springjpa.advanced.customhbmtype;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Data
public class ContainerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Type(type="com.klezovich.springjpa.advanced.customhbmtype.BracketPairType")
    private BracketPair pair;
}
