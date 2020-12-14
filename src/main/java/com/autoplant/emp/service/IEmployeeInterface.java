package com.autoplant.emp.service;

import java.util.List;

import com.autoplant.emp.dto.EmployeePayrollDTO;
import com.autoplant.emp.dto.ResponseDTO;

public interface IEmployeeInterface {
	
	public ResponseDTO addEmployee(EmployeePayrollDTO emp);
	public List<EmployeePayrollDTO> getEmployeeList();
	public ResponseDTO deleteEmployee(int id);
	public EmployeePayrollDTO getEmployee(int id);
	public EmployeePayrollDTO updateUser(EmployeePayrollDTO employeePayrollDto, int id);
}
