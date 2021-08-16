 package com.shrimanju.employeebackend.repository;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;

import com.shrimanju.employeebackend.model.Employee;

 @Repository
 public interface EmployeeRepository extends JpaRepository<Employee, Long>{

 }