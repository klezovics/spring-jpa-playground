package com.klezovich.springjpa.relationships.onetoone.personlicense;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

@Entity
public class Licence {
    @Id
    @GeneratedValue
    private Long id;
    private String serialNumber;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
