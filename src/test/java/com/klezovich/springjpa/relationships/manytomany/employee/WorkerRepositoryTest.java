package com.klezovich.springjpa.relationships.manytomany.employee;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static java.util.stream.Collectors.toSet;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class WorkerRepositoryTest {

    @Autowired
    private WorkerRepository repository;

    @Test
    void testCanSaveAndLoadEmployeeWithProjects() {
        var emp1 = Worker.builder().name("AK").build();
        var emp2 = Worker.builder().name("Tarasik").build();

        var p1 = Project.builder().name("Learn Java").build();
        var p2 = Project.builder().name("Learn Spring").build();

        emp1.addProject(p1);
        emp1.addProject(p2);

        emp2.addProject(p1);

        var id1 = repository.save(emp1).getId();
        var id2 = repository.save(emp2).getId();

        var savedEmp1 = repository.findById(id1).get();
        assertNotNull(savedEmp1);
        assertEquals("AK",savedEmp1.getName());

        var emp1ProjectNames = emp1.getProjects().stream()
                .map(Project::getName)
                .collect(toSet());

        assertEquals(2, emp1ProjectNames.size());
        assertThat(emp1ProjectNames, containsInAnyOrder("Learn Java", "Learn Spring"));

        var savedEmp2 = repository.findById(id2).get();

        assertNotNull(savedEmp2);
        assertEquals("Tarasik",savedEmp2.getName());

        var emp2ProjectNames = emp2.getProjects().stream()
                .map(Project::getName)
                .collect(toSet());

        assertThat(emp2ProjectNames, containsInAnyOrder("Learn Java"));
    }
}