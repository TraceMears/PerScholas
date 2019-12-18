package classes;

public class Employee {
	//field values
	private String name;
	private int salary;
	private String position;
	private String department;
	private String manager;
	private int vacationDays;
	
	//constructors
	public Employee(String name, int sal, String pos) {
		this.name = name;
		this.salary = sal;
		this.position = pos;
	}	
	public Employee(String name, int sal, String pos, String dep, String man, int vac) {
		this.name = name;
		this.salary = sal;
		this.position = pos;
		this.department = dep;
		this.manager = man;
		this.vacationDays = vac;
	}
	
	//getter and setter methods
	public int getSalary() {
		return this.salary;
	}	
	public void setSalary(int newSal) {
		this.salary = newSal;
	}
	
	public String getPosition() {
		return this.position;
	}
	public void setPosition(String newPos) {
		this.position = newPos;
	}
	
	public String getDepartment() {
		return this.department;
	}
	public void setDepartment(String newDep) {
		this.department = newDep;
	}
	
	public String getManager() {
		return this.manager;
	}
	public void setManager(String newMan) {
		this.manager = newMan;
	}
	
	public int getVacationDays() {
		return this.vacationDays;
	}
	public void addVacationDays(int vacAdd) {
		this.vacationDays += vacAdd;
	}
	public void subtractVacationDays(int vacSub) {
		this.vacationDays -= vacSub;
	}
	
	//method to print out all fields of an Employee object
	public void print() {
		System.out.println("Name: " +  this.name);
		System.out.println("Salary: " +  this.salary);
		System.out.println("Position: " + this.position);
		System.out.println("Department: " + this.department);
		System.out.println("Manager: " + this.manager);
		System.out.println("Remaining Vactation Days: " + this.vacationDays);
		System.out.println();
	}
	
}
