package com.autoplant.emp.service;

import com.autoplant.emp.dto.EmployeePayrollDTO;
import com.autoplant.emp.dto.ResponseDTO;

public interface IEmployeeInterface {
	
	public ResponseDTO addEmployee(EmployeePayrollDTO emp);
}
