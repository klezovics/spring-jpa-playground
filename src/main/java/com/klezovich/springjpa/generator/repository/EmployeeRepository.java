package com.klezovich.springjpa.generator.repository;

import com.klezovich.springjpa.generator.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
