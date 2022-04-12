package com.learning.spring.boot.learning.repository;

import com.learning.spring.boot.learning.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

 /*
 * 1.Testing the REpo leayer is bit complex as it involves the DB and during we need to make sure that
 * 2. we don't inject any data into the DB....so for that we use the TestEntityManager object which directly comes from the
 * 3. JPA repo layer...it'll test the data which we wanna test without inserting the data into the DB.
 *
 * */
@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("ECE")
                        .departmentCode("ECE-106")
                        .departmentAddress("DELHI")
                        .build();

        entityManager.persist(department); //mocking the DB and not actually inserting it to any DB
    }

    @Test
    public void whenFindById_thenReturnDepartment(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "ECE");
    }
}