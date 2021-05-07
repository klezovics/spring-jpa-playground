package com.klezovich.springjpa.generator.repository;

import com.klezovich.springjpa.generator.entity.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJpaTest
@Slf4j
//TO READ https://www.baeldung.com/hibernate-identifiers
//TO READ https://www.baeldung.com/jpa-strategies-when-set-primary-key
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository repository;

    @Test
    //The default PK generation strategy is GenerationType.AUTO
    //This forces hibernate on its own, based on the provided DB driver
    //to select an ID generation strategy
    void testGenerationTypeAuto() {
        var employee = Employee.builder().name("AK").build();
        repository.save(employee);

        assertNotNull(employee.getId());
        log.info("Generated id is:" + employee.getId());
    }

}