package org.dxc.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.dxc.dao.EmployeeDaoImpl;
import org.dxc.model.Employee;

public class Client {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		EmployeeDaoImpl dao = new EmployeeDaoImpl();
		
		List<Integer> arr= new ArrayList<Integer>();
		
		while(true) {
			System.out.println("1 - Adding an Employee to DataBase");
			System.out.println("2 - Fetching the list of Employees");
			System.out.println("3 - Updating the Employee details");
			System.out.println("4 - Deleting an Employee");
			System.out.println("5 - Exit");	
			System.out.println();
			System.out.print("Enter the operation you want to perform - ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			System.out.println();
			
			switch(choice) {			
				case 1:
				{	
						System.out.println("Enter employee details: ");								
						System.out.print("Enter Employee Name: ");
						String empName = scanner.nextLine();
						System.out.print("Enter Employee Age: ");
						int empAge = scanner.nextInt();
						System.out.print("Enter Employee Salary: ");
						double empSalary = scanner.nextDouble();	
						int empId = dao.saveEmployee(empName, empAge, empSalary);
						arr.add(empId);
						System.out.println();
						System.out.println("Employee details successfully added to database with id  " + empId);
						System.out.println();
						break;
				}		
				case 2:
				{		
						
						List<Employee> empList = dao.getAllEmployees();	
						System.out.println();
						System.out.println("Employees : ");
						System.out.println();
						for(Employee emp: empList) {
							System.out.println(emp);
						}
						System.out.println();
						System.out.println();
						break;
						
				}		
				case 3:
				{
						System.out.println("Enter the Id from the Employee list:");
						System.out.println(arr);
						System.out.print("Enter the id :");
						int empId = scanner.nextInt();	
						System.out.print("Choose the information you want to update Age / Salary (1 / 2) ?: ");
						int ch = scanner.nextInt();
						scanner.nextLine();
					
						switch(ch) {
						
							case 1:
							{
								System.out.print("Enter the new age: ");
								int age = scanner.nextInt();	
								dao.updateEmployee(empId, age);
								Employee emp = dao.getEmployee(empId);
								System.out.println();
								System.out.println("Updated Successfully!");
								System.out.println("Updated Employee details: "+ emp);
								System.out.println();
								break;
							}
							
							case 2:
							{
								System.out.print("Enter the new salary: ");
								double salary = scanner.nextDouble();			
								dao.updateEmployee(empId, salary);
								Employee emp = dao.getEmployee(empId);	
								System.out.println();
								System.out.println("Updated Successfully!");
								System.out.println("Updated Employee details: "+ emp);
								System.out.println();
								break;
							}
						}
						break;
				}		
				case 4:
				{
						System.out.println(arr);
						System.out.print("Choose the employeeId you want to delete: ");
						int empId = scanner.nextInt();
						Employee emp = dao.getEmployee(empId);
						System.out.println();
						System.out.println("The employee details you want to delete: "+ emp);
						System.out.print("Do you want to delete ( Y / N) ? : ");
						scanner.nextLine();
						String input = scanner.nextLine();
						System.out.println(input);
						if(input.equalsIgnoreCase("Y") == true) {
							dao.deleteEmployee(empId);
							System.out.println("Employee details deleted Successfully!");
							System.out.println();
						} else {
							System.out.println("Deletion aborted!");
							System.out.println();
						}
						break;
				}		
				case 5:	
						scanner.close();
						System.out.println("Bye!");
						System.exit(0);
						
				default:
						System.out.println("Please enter a valid choice!");
						System.out.println();
						break;
			}
			
		}

	}

}
