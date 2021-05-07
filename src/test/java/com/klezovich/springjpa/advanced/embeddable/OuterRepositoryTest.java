package com.klezovich.springjpa.advanced.embeddable;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class OuterRepositoryTest {

    @Autowired
    private OuterRepository repository;

    @Test
    void testCanSaveAndLoadEmbeddableEntity() {
        var o = new Outer();
        o.setOuterName("outer_name");

        var i = new Inner();
        i.setInnerId("inner_id");
        i.setInnerName("inner_name");

        o.setInner(i);

        var savedOuter = repository.save(o);
        assertTrue(Objects.nonNull(savedOuter.getId()));

        var outerFromDb = repository.findById(savedOuter.getId()).get();
        assertEquals("outer_name",outerFromDb.getOuterName());

        var innerFromDb=outerFromDb.getInner();
        assertEquals("inner_id",innerFromDb.getInnerId());
        assertEquals("inner_name",innerFromDb.getInnerName());
    }
}