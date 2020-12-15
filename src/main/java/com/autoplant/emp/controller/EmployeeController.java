package com.autoplant.emp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autoplant.emp.dto.EmployeePayrollDTO;
import com.autoplant.emp.dto.ResponseDTO;
import com.autoplant.emp.service.IEmployeeInterface;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
	
	@Autowired
	public IEmployeeInterface employeePayrollService;
	@Value("${my.name}")
	private String author;
	
	@RequestMapping(value= {"","/"})
	public ResponseEntity<String> getEmpData(){
		return new ResponseEntity<String>("Getting started with Payroll App By "+author,HttpStatus.OK);
	}

	@PostMapping("/insert")
	public ResponseEntity<ResponseDTO> addEmployee(@Valid @RequestBody EmployeePayrollDTO empDTO){
		return new ResponseEntity<ResponseDTO>(employeePayrollService.addEmployee(empDTO),HttpStatus.OK);
	}
	@GetMapping("/list")
	public ResponseEntity<List<EmployeePayrollDTO>> getEmployee(){
		return new ResponseEntity<List<EmployeePayrollDTO>>(employeePayrollService.getEmployeeList(),HttpStatus.OK);
	}
    
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteEmplyoee(@PathVariable int id) {
        return new ResponseEntity<ResponseDTO>(employeePayrollService.deleteEmployee(id), HttpStatus.OK);
    }
    @GetMapping(value = "/get/{id}")
    public ResponseEntity<EmployeePayrollDTO> getEmployeeById(@PathVariable int id) {
        return new ResponseEntity<EmployeePayrollDTO>(employeePayrollService.getEmployee(id), HttpStatus.OK);
    }
    @PutMapping(value="/update/{id}")
    public ResponseEntity<EmployeePayrollDTO> updateEmployeeById(@RequestBody EmployeePayrollDTO empDTO,@PathVariable int id) {
        return new ResponseEntity<EmployeePayrollDTO>(employeePayrollService.updateUser(empDTO, id), HttpStatus.OK);
    }

}
