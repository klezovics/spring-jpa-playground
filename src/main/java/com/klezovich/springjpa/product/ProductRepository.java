package com.klezovich.springjpa.product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    List<Product> findByNameStartingWith(String namePrefix);

    List<Product> findByPriceGreaterThan(Integer minPrice);

    @Query(value = "SELECT p FROM Product p where p.name like 'PROD%'")
    List<Product> findAllGenericProducts();

    @Query(value = "SELECT * FROM product p where p.price=1000", nativeQuery = true)
    List<Product> findProductsThatCost1000();
}
