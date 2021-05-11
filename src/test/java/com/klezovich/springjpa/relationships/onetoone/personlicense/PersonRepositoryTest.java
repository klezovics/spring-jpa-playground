package com.klezovich.springjpa.relationships.onetoone.personlicense;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository repository;

    @Test
    void testCanSaveAndLoadPersonWithLicense() {
        var person = Person.builder().name("AK").build();
        var license = Licence.builder().serialNumber("111222").build();

        person.addLicense(license);

        var id = repository.save(person).getId();
        assertNotNull(id);

        var savedPerson = repository.findById(id).get();
        log.info("{}",savedPerson);


        assertNotNull(savedPerson.getId());
        assertEquals("AK",savedPerson.getName());

        var savedLicence = savedPerson.getLicence();
        log.info("{}",savedLicence);

        assertNotNull(savedLicence.getId());
        assertNotNull(savedLicence.getPerson());
        assertEquals("111222",savedLicence.getSerialNumber());
    }
}