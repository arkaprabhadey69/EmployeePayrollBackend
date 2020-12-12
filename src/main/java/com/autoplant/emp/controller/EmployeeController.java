package com.autoplant.emp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autoplant.emp.dto.EmployeePayrollDTO;
import com.autoplant.emp.dto.ResponseDTO;
import com.autoplant.emp.service.IEmployeeInterface;

@RestController
public class EmployeeController {
	@RequestMapping(value= {"","/","/get"})
	public ResponseEntity<String> getEmpData(){
		return new ResponseEntity<String>("Getting started with Payroll App",HttpStatus.OK);
	}
	public IEmployeeInterface employeePayrollService;
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployee(@RequestBody EmployeePayrollDTO empDTO){
		return new ResponseEntity<ResponseDTO>(employeePayrollService.addEmployee(empDTO),HttpStatus.OK);
	}

}
