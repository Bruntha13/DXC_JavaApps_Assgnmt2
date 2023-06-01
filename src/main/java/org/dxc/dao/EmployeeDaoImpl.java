package org.dxc.dao;

import java.util.List;

import org.dxc.model.Employee;
import org.dxc.util.HibernateUtil;
import org.hibernate.Session;

public class EmployeeDaoImpl {
public int saveEmployee(String name, int age, double salary) {
		
		Employee employee = new Employee();
		employee.setEmployeeName(name);
		employee.setEmployeeAge(age);
		employee.setEmployeeSalary(salary);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		int id = (Integer) session.save(employee);
		
		session.getTransaction().commit();
		session.close();
		
		return id;
	}

	public List<Employee> getAllEmployees() {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		@SuppressWarnings("unchecked")
		List<Employee> empList = (List<Employee>) session.createQuery("FROM Employee e ORDER BY e.employeeName ASC").list();

		session.getTransaction().commit();
		session.close();

		return empList;
	}

	public void updateEmployee(int id, int age) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, id);
		employee.setEmployeeAge(age);
		// session.update(student);//no need to call update manually as it will be
		// updated automatically on transaction close
		session.getTransaction().commit();
		session.close();
	}

	public void updateEmployee(int id, double salary) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, id);
		employee.setEmployeeSalary(salary);
		// session.update(student);//no need to call update manually as it will be
		// updated automatically on transaction close
		session.getTransaction().commit();
		session.close();
		
	}

	public void deleteEmployee(int id) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, id);
		session.delete(employee);
		session.getTransaction().commit();
		session.close();
	}

	public Employee getEmployee(int id) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		
		Employee employee = (Employee) session.get(Employee.class, id);
//		session.delete(employee);
		
		session.getTransaction().commit();
		session.close();
		
		return employee;
	}
}
