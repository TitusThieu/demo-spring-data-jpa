package com.tutorial.repo;

import com.tutorial.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepo extends CrudRepository<Employee, Long> {
    List findByLastName(String lastName);

    @Query("SELECT e FROM Employee e WHERE e.age = :age")
    List findByAge(@Param("age") int age);
}
