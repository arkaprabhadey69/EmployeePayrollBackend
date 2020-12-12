package com.autoplant.emp.dto;

public class EmployeePayrollDTO {
	
	private String name;
	private String gender;
	private String imgPath;
	private String dept;
	private int salary;
	private String startDate;
	private String notes;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "EmployeePayrollDTO [name=" + name + ", gender=" + gender + ", imgPath=" + imgPath + ", dept=" + dept
				+ ", salary=" + salary + ", startDate=" + startDate + ", notes=" + notes + "]";
	}
	
}
