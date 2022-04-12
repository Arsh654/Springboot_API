package com.learning.spring.boot.learning.repository;

import com.learning.spring.boot.learning.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Here we are extending the JPA repo bcoz by default it'll provide us the
//various method to work on without even writing the actual code....BASTRACTION way
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentName(String departmentName);
    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
