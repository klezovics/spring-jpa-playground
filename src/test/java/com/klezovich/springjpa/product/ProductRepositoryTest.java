package com.klezovich.springjpa.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @BeforeEach
    void setup() {
        var p1 = Product.builder().name("SKU123").price(1).build();
        repository.save(p1);

        var p2 = Product.builder().name("DIAMOND").price(1000).build();
        repository.save(p2);

        for(int ii=1;ii<4;ii++) {
            repository.save(Product.builder().name("PROD"+ii).price(ii*10).build());
        }
    }

    @Test
    //TO READ: https://www.baeldung.com/spring-data-derived-queries
    void testSpringDataFinderMethods() {
        var prods = repository.findByNameStartingWith("SKU");
        assertEquals(1, prods.size());
        assertEquals("SKU123", prods.get(0).getName());

        prods =repository.findByPriceGreaterThan(999);
        assertEquals(1, prods.size());
        assertEquals("DIAMOND", prods.get(0).getName());
    }

    @Test
    //TO READ: https://www.baeldung.com/spring-data-jpa-pagination-sorting
    void testSpringDataPagingMethods() {
        var pageable = PageRequest.of(0,2); // page index starts with 0
        var prods = repository.findAll(pageable);

        //5 prods total in pages of 2 we get pages with sizes 2, 2, 1
        assertEquals(2, prods.getContent().size());
        assertEquals(2,repository.findAll(PageRequest.of(1,2)).getContent().size());
        assertEquals(1, repository.findAll(PageRequest.of(2,2)).getContent().size());
    }

    @Test
    //TO READ: https://www.baeldung.com/spring-data-jpa-pagination-sorting
    void testSpringDataSortingMethods() {
        var prods = repository.findAll(Sort.by(Sort.Direction.ASC,"price"));
        var prodList =  StreamSupport.stream(prods.spliterator(), false)
                .collect(Collectors.toList());

        assertEquals(5, prodList.size());
        assertEquals(1,prodList.get(0).getPrice());
        assertEquals(10,prodList.get(1).getPrice());
        assertEquals(20,prodList.get(2).getPrice());
    }

    @Test
    //TO READ: https://www.baeldung.com/spring-data-jpa-query
    void testJpqlMethods() {
        var prods = repository.findProductsThatCost1000();
        assertEquals(1,prods.size());
    }

    @Test
    void testNativeSqlMethods() {
        var prods = repository.findProductsThatCost1000();
        assertEquals(1,prods.size());
        assertEquals("DIAMOND",prods.get(0).getName());
    }

}