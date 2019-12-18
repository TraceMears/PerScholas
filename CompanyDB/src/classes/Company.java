package classes;

import java.util.ArrayList;

public class Company {
	//field value of Company's employee DataBase
	private ArrayList<Employee> employeeDB = new ArrayList<Employee>();
	
	//overloaded methods to hire employees(add to db) with different parameter combinations
	public void hireEmployee(Employee emp) {
		this.employeeDB.add(emp);
	}
	public void hireEmployee(Employee emp, String name, int sal, String pos) {
		emp = new Employee(name, sal, pos);
		this.employeeDB.add(emp);
	}
	public void hireEmployee(Employee emp, String name, int sal, String pos, String dept, String mgr, int vDays) {
		emp =  new Employee(name, sal, pos, dept, mgr, vDays);
		this.employeeDB.add(emp);
	}
	//method to fire employee(remove from AL)
	public void fireEmployee(Employee emp) {
		this.employeeDB.remove(emp);
	}
	
	//methods to change employee values from the company object
	public void changeSalary(Employee emp, int newSal) {
		this.employeeDB.get(this.employeeDB.indexOf(emp)).setSalary(newSal);
	}
	public void changePosition(Employee emp, String newPos) {
		this.employeeDB.get(this.employeeDB.indexOf(emp)).setPosition(newPos);
	}
	public void changeDepartment(Employee emp, String newDep) {
		this.employeeDB.get(this.employeeDB.indexOf(emp)).setDepartment(newDep);
	}
	public void changeManager(Employee emp, String newMan) {
		this.employeeDB.get(this.employeeDB.indexOf(emp)).setManager(newMan);
	}
	public void addVacationDays(Employee emp, int days) {
		this.employeeDB.get(this.employeeDB.indexOf(emp)).addVacationDays(days);
	}
	public void removeVacationDays(Employee emp, int days) {
		this.employeeDB.get(this.employeeDB.indexOf(emp)).subtractVacationDays(days);
	}
	
	public void printEmployee(Employee emp) {
		this.employeeDB.get(this.employeeDB.indexOf(emp)).print();
	}
	public void printCompany() {
		for(Employee emp : this.employeeDB) {
			emp.print();
		}
	}
}
