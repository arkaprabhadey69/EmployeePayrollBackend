package com.autoplant.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autoplant.emp.dto.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
