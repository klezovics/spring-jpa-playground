package com.klezovich.springjpa.advanced.customhbmtype;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContainerEntityRepisotory extends CrudRepository<ContainerEntity,Long> {
}
