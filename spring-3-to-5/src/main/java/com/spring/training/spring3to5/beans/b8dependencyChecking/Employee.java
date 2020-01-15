package com.spring.training.spring3to5.beans.b8dependencyChecking;

public class Employee {
	private int empId;
	private Person emp;
	
	Employee(){
		
	}
	
	@Override
	public String toString() {
		return "Employee [" + empId + ", " + emp.getName() + ", from " + emp.getCountry() +"]";
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public Person getEmp() {
		return emp;
	}
	public void setEmp(Person emp) {
		this.emp = emp;
	}

}
