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
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Setter(AccessLevel.NONE)
    @ToString.Exclude
    private Licence licence;

    void addLicense(Licence licence) {
        licence.setPerson(this);
        this.licence = licence;
    }
}
