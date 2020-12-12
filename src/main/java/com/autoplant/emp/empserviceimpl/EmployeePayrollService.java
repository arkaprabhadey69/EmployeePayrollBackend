package com.autoplant.emp.empserviceimpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autoplant.emp.dto.EmployeeEntity;
import com.autoplant.emp.dto.EmployeePayrollDTO;
import com.autoplant.emp.dto.ResponseDTO;
import com.autoplant.emp.repository.EmployeeRepository;
import com.autoplant.emp.service.IEmployeeInterface;

@Service
public class EmployeePayrollService implements IEmployeeInterface {
	
@Autowired
private EmployeeRepository employeeRepository;

@Override
public ResponseDTO addEmployee(EmployeePayrollDTO emp)
{
	EmployeeEntity empEntity= new EmployeeEntity();
	empEntity.setName(emp.getName());
	empEntity.setGender(emp.getGender());
	empEntity.setImgPath(emp.getImgPath());
	empEntity.setDept(emp.getDept());
	empEntity.setSalary(emp.getSalary());
	empEntity.setStartDate(new Date());
	empEntity.setNotes(emp.getNotes());
	
	empEntity=employeeRepository.save(empEntity);
	if(empEntity!=null) {
		return new ResponseDTO("Success");
	}
	else 
		return new ResponseDTO("Failure");
	
	
}
}
