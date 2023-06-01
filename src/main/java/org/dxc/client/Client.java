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
			
//			Options List
	
			System.out.println("Press 1. To Save an Employee to DB");
			System.out.println("Press 2. To get the list of all Employees");
			System.out.println("Press 3. To Update the Employee details");
			System.out.println("Press 4. To Delete an Employee");
			System.out.println("Press 5. To Exit");
			
			System.out.println();
			
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			System.out.println();
			
			switch(choice) {
			
				case 1:
				{	
						System.out.println("Enter the employee details: ");
						
//						System.out.println();
						
						System.out.print("Enter the employeeName: ");
						String empName = scanner.nextLine();
//						System.out.println();
						
						System.out.print("Enter the employeeAge: ");
						int empAge = scanner.nextInt();
//						System.out.println();
						
						
						System.out.print("Enter the employeeSalary: ");
						double empSalary = scanner.nextDouble();
//						System.out.println();
						
						
						int empId = dao.saveEmployee(empName, empAge, empSalary);
						
						arr.add(empId);
						
//						for(Integer i : arr) {
//							System.out.println(i + " ");
//						}
//						System.out.println(arr);
						
						System.out.println();
						System.out.println("Employee saved successfully with id  " + empId);
						System.out.println();
						break;
				}		
				case 2:
				{		
						
						List<Employee> empList = dao.getAllEmployees();
						
						System.out.println();
						System.out.println("Here is the list of all Employees : ");
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
						System.out.println("Choose an Id from the list below:");
						
//						for(Integer id : arr) {
//							System.out.print("[ ");
//							System.out.print(id + " ");
//							System.out.println("]");
//							
//						}
						System.out.println(arr);
						
						System.out.print("Enter the id :");
						int empId = scanner.nextInt();
						
						System.out.print("What information do you want to update Age / Salary (1 / 2) ?: ");
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
								System.out.println("Updated Employee Info: "+ emp);
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
								System.out.println("Updated Employee Info: "+ emp);
								System.out.println();
								break;
							}
						}
						
						
						break;
				}		
				case 4:
				{
						// Option to Delete
						
//						System.out.println("Choose the employeeId to delete:");
						
//						for(Integer id : arr) {
//							System.out.println(id + " ");
//						}
					
						System.out.println(arr);
						
						System.out.print("Choose the employeeId to delete: ");
						int empId = scanner.nextInt();
						
						Employee emp = dao.getEmployee(empId);
						
						System.out.println();
						System.out.println("Here is the emp details : "+ emp);
						System.out.print("Do you want to delete ( Y / N) ? : ");
						
						scanner.nextLine();
						
						String input = scanner.nextLine();
						
						System.out.println(input);
						
						if(input.equalsIgnoreCase("Y") == true) {
							dao.deleteEmployee(empId);
							System.out.println("Object Deleted Successfully!");
							System.out.println();
						} else {
							System.out.println("Operation Cancelled!");
							System.out.println();
						}
						
						break;
				}		
				case 5:	
						scanner.close();
						System.out.println("Program Exited!");
						System.exit(0);
						
				default:
						System.out.println("Wrong choice! Try Again");
						System.out.println();
						break;
			}
			
		}

	}

}
