package com.autoplant.emp.empserviceimpl;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autoplant.emp.dto.EmployeeEntity;
import com.autoplant.emp.dto.EmployeePayrollDTO;
import com.autoplant.emp.dto.ResponseDTO;
import com.autoplant.emp.exceptions.NotFoundException;
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
@Override
public List<EmployeePayrollDTO> getEmployeeList() {
	List<EmployeeEntity> emplList = employeeRepository.findAll();
	if (emplList == null || emplList.isEmpty()) {
		throw new NotFoundException("No Data Found of any employee");
	}
	return emplList.stream().map(employee -> {
		EmployeePayrollDTO emp = convertobj(employee);
		return emp;
	}).collect(Collectors.toList());
}
@Override
public ResponseDTO deleteEmployee(int id) {
	employeeRepository.deleteById(id);
	return new ResponseDTO("Employee Deleteed Successfully..!!");
}
@Override
public EmployeePayrollDTO getEmployee(int id) {
	EmployeeEntity employee = employeeRepository.findById(id);
	if(employee == null) {
		throw new NotFoundException("No Data Found for the id:"+id);
	}
	EmployeePayrollDTO emp = convertobj(employee);
	return emp;
}
@Override
public EmployeePayrollDTO updateUser(EmployeePayrollDTO employeePayrollDto,int id){

	EmployeeEntity employee = employeeRepository.findById(id);
	if(employee == null) {
		throw new NotFoundException("No Data Found for the id:"+id);
	}
	if(Objects.nonNull(employeePayrollDto.getSalary())) {
		employee.setSalary(employeePayrollDto.getSalary());
	}
	employeeRepository.save(employee);
	EmployeePayrollDTO emp = convertobj(employee);
	return emp;
}
private EmployeePayrollDTO convertobj(EmployeeEntity employee) {
	EmployeePayrollDTO  emp = new EmployeePayrollDTO ();
	
	emp.setName(employee.getName());
	emp.setDept(employee.getDept());
	emp.setSalary(employee.getSalary());
	emp.setGender(employee.getGender());
	emp.setImgPath(employee.getImgPath());
	emp.setStartDate("");
	emp.setNotes(employee.getNotes());
	return emp;
}

}
