package com.learning.spring.boot.learning.service;

import com.learning.spring.boot.learning.entity.Department;
import com.learning.spring.boot.learning.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        //we want to create a  ref of our dept class...we can create by using the constructor
        //or with the getter or setter but there's one build patter comes form lombok dept
        //allow us to create the ref object with minimal configuration
        Department department =
                Department.builder()
                        .departmentName("IT")
                        .departmentAddress("DELHI")
                        .departmentCode("DL-016")
                        .departmentId(1L)
                        .build();

        //since the findby.. method is in the repo layer so we need to mock the object fot it and it's done by the
        //mocktio perfectly
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
    }

    @Test //marking it's a Test method.
    @DisplayName("Get Data when valid Department Name is Passed") //This will be printed when our test Cases passes successfully.
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        //Creating a dept name which will be checked and acts as a test cases.
        String departmentName = "IT";

        //found refer variable of dept class will be the one with which we are going to match out test cases.
        Department found = departmentService.fetchDepartmentByName(departmentName);

        //assert equal will check whether the 2 entities are equal or not
        assertEquals(departmentName, found.getDepartmentName());
    }
}


















