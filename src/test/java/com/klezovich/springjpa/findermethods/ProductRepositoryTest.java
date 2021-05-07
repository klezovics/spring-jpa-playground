package com.klezovich.springjpa.findermethods;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
//TO READ: https://www.baeldung.com/spring-data-derived-queries
class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @BeforeEach
    void setup() {
        var p1 = Product.builder().name("SKU123").price(1).build();
        repository.save(p1);

        var p2 = Product.builder().name("DIAMOND").price(1000).build();
        repository.save(p2);

    }

    @Test
    void testSpringDataFinderMethods() {
        var prods = repository.findByNameStartingWith("SKU");
        assertEquals(1, prods.size());
        assertEquals("SKU123", prods.get(0).getName());

        prods =repository.findByPriceGreaterThan(999);
        assertEquals(1, prods.size());
        assertEquals("DIAMOND", prods.get(0).getName());
    }

}