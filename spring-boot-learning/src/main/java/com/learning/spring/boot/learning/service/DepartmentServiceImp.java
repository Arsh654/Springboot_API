package com.learning.spring.boot.learning.service;

import com.learning.spring.boot.learning.entity.Department;
import com.learning.spring.boot.learning.error.departmentNotFoundException;
import com.learning.spring.boot.learning.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImp implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws departmentNotFoundException {
        Optional<Department> department =
                departmentRepository.findById(departmentId);

        if(!department.isPresent()){
            throw new departmentNotFoundException("Department You are searching for is not Present in The Database.");
        }

        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        //pooping out the object from the DB of departmentId and see whether its empty or what.
        Department depDB = departmentRepository.findById(departmentId).get();

        //Checking if any one of the 3 fields is empty or null
        //if yes then we don't gonna update it..

        if(Objects.nonNull(department.getDepartmentName()) &&
        !"".equalsIgnoreCase(department.getDepartmentName())){

            depDB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())){

            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())){

            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        //saving the newly Modified(ID SO) to the DataBase.
        return departmentRepository.save(depDB);


    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
