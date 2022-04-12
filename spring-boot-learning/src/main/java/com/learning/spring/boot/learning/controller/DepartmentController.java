package com.learning.spring.boot.learning.controller;

import com.learning.spring.boot.learning.entity.Department;
import com.learning.spring.boot.learning.error.departmentNotFoundException;
import com.learning.spring.boot.learning.service.DepartmentService;
import com.learning.spring.boot.learning.service.DepartmentServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private static Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);


    //Send the dept details and save it to the DB
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController Class");
        return departmentService.saveDepartment(department);
    }

    //fetch all the things from the DB

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside fetchDepartmentList of DepartmentController Class");
        return departmentService.fetchDepartmentList();
    }

    //Fetch Dept. details by only id;

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws departmentNotFoundException {
        LOGGER.info("Inside fetchDepartmentById of DepartmentController Class");
        return departmentService.fetchDepartmentById(departmentId);
    }

    //Delete Data From the DB

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        LOGGER.info("Inside deleteDepartmentById of DepartmentController Class");
        departmentService.deleteDepartmentById(departmentId);

        return "Deleted the entry Successfully!!!PHEWWW....";
    }

    //updating the dept. data
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department){
        LOGGER.info("Inside updateDepartment of DepartmentController Class");
        return departmentService.updateDepartment(departmentId, department);
    }
    //departmentId:- for which id u want to make modification
    // department :- Object corresponding to that ID.

    //finding data by deptName endpoint

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        LOGGER.info("Inside fetchDepartmentByName of DepartmentController Class");
        return departmentService.fetchDepartmentByName(departmentName);
    }
}







