package JavaPrograms;

public class EmployeeSalary {
private String employee;
private int salary;
public void set(String employee, int salary) {
	this.employee=employee;
	this.salary=salary;
}
public void get() {
	System.out.println("Employee "+employee);
	System.out.println("Salary "+salary);
}
public static void main(String []args) {
	EmployeeSalary obj=new EmployeeSalary();
	obj.set("Anu",2400);
	obj.get();
}
}
