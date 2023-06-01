package org.dxc.dao;

import java.util.List;

import org.dxc.model.Employee;

public interface EmployeeDao {
	int saveEmployee(String name, int age, double salary);
	List<Employee> getAllEmployees();
	void updateEmployee(int id, int age);
	void updateEmployee(int id, double salary);
	void deleteEmployee(int id);
	Employee getEmployee(int id);
}
