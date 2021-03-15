package com.klezovich.springjpa.embeddable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OuterRepository extends CrudRepository<Outer,Long> {
}
