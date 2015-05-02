package testPackage;


import java.util.GregorianCalendar;

public class ClassInheritance {

	public static void main(String[] args) {
		Employee[] employeeList = new Employee[3];
		
		Manager m1 = new Manager("Ryszkowski", 1000, 2015, 3, 1);

		System.out.println("----------------------------------------------------------------------------------------------------------");
		
		employeeList[0] = m1;
		employeeList[1] = new Employee("Kowalik", 2000, 2015, 1, 5);
		employeeList[2] = new Employee("Mandaryniak", 3000, 2015, 2, 17);
		
		for(int i=0; i<employeeList.length; i++){
			System.out.println(employeeList[i].toString());
		}
		
		System.out.println("----------------------------------------------------------------------------------------------------------");
		System.out.println("--BONUS ADDING:");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		
		m1.setBonus(300);
		employeeList[0] = m1;
		
		for(int i=0; i<employeeList.length; i++){
			System.out.println(employeeList[i].toString());
		}
		
		System.out.println("----------------------------------------------------------------------------------------------------------");
	}
}


class Manager extends Employee{
	Manager(String n, double s, int y, int m, int d){
		super(n, s, y, m, d);
	}
	Manager(String n, double s, int y, int m, int d, double b){
		super(n, s, y, m, d);
		//this.bonus = b; //ni¿ej tak napisano
		setBonus(b);
	}
	
	public void setBonus(double b){
		this.bonus = b;
	}
	public double getBonus(){
		return this.bonus;
	}
	public double getSalary(){
		double actualSalary = super.getSalary();
		actualSalary = actualSalary + getBonus();
		return actualSalary;
	}
	
	@Override
	public String toString(){
		return "ID: " + super.getId()
				+ " | NAME: " + super.getName()
				+ " | SALARY: " + getSalary()
				+ " | DATE OF EMPLOYMENT: " + super.getDateEmployment().getTime();
	}
	
	private double bonus = 0;
}


class Employee{
	Employee(String n, double s, int y, int m, int d){
		this.name = n;
		this.salary = s;
		//this.dateEmployment = new Date(y, m, d);
		this.dateEmployment = new GregorianCalendar(y, (m-1), d);
		this.Id = nextId;
		nextId++;
	}
	
	public int getId(){
		return this.Id;
	}
	public String getName(){
		return this.name;
	}
	public double getSalary(){
		return this.salary;
	}
	public GregorianCalendar getDateEmployment(){
		return this.dateEmployment;
	}
	
	public String toString(){
		return "ID: " + this.Id
				+ " | NAME: " + this.name
				+ " | SALARY: " + this.salary
				+ " | DATE OF EMPLOYMENT: " + this.dateEmployment.getTime();
	}
	
	private static int nextId = 1;
	private int Id = 0;
	private String name = "";
	private double salary = 0;
	//private Date dateEmployment = null;
	GregorianCalendar dateEmployment = null;
}