package com.klezovich.springjpa.product;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    List<Product> findByNameStartingWith(String namePrefix);

    List<Product> findByPriceGreaterThan(Integer minPrice);
}
