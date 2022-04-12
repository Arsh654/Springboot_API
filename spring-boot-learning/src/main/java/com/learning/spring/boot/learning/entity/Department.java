package com.learning.spring.boot.learning.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity //for making enable to interact with DB
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id //for primary key Purpose
    @GeneratedValue(strategy = GenerationType.AUTO) //Generating the Primary Key.
    private Long departmentId;

    @NotBlank(message="Please add the Department Name")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;


}
