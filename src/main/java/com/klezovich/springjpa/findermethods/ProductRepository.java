package com.klezovich.springjpa.findermethods;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByNameStartingWith(String namePrefix);

    List<Product> findByPriceGreaterThan(Integer minPrice);
}
