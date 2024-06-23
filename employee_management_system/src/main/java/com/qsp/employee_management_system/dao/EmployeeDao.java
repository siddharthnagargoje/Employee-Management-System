package com.qsp.employee_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qsp.employee_management_system.dto.Employee;
import com.qsp.employee_management_system.repo.EmployeeRepo;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepo repo;
	
	public Employee saveEmployee( Employee employee)
	{
		return repo.save(employee);
	}
	
	public List<Employee> saveAllEmployee( List<Employee> employees) {
		return repo.saveAll(employees);
	}
	
	public Employee findEmployeeById( int id) {
		Optional< Employee> optional=repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}
	
	public List<Employee> findEmployeeByName(String name) {
		return repo.findByName(name);
	}
	public Employee findByPhone( long phone) {
		return repo.findByPhone(phone);
	}
	
	public Employee findByEmail( String email) {
		return repo.getByEmail(email);
	}

	public List<Employee> findByAddress(String address) {
		return repo.findByAddress(address);
	}
	
	public List<Employee> findByDesignation(String designation) {
		return repo.findByDesignation(designation);
	}
	
	public List<Employee> findAll() {
		return repo.findAll();
	}
	
	public List<Employee> salaryLessThan(double salary) {
		return repo.findBySalaryLessThan(salary);
	}
	
	public List<Employee> salaryGreaterThan(double salary) {
		return repo.findBySalaryGreaterThan(salary);
	}
	
	public List<Employee> salaryBetween(double salary1, double salary2) {
		return repo.findBySalaryBetween(salary1, salary2);
	}

	public Employee updateName(int id, String name) {
		Optional<Employee> employee= repo.findById(id);
		if (employee.isPresent()) {
			Employee employee1=employee.get();
			employee1.setName(name);
			return repo.save(employee1);
		} else {
			return null;
		}
	}
	
	public Employee updatePhone(int id, long phone) {
		Optional<Employee> employee= repo.findById(id);
		if (employee.isPresent()) {
			Employee employee1=employee.get();
			employee1.setPhone(phone);
			return repo.save(employee1);
		} else {
			return null;
		}
	}
	
	public Employee updateAddress(int id, String address) {
		Optional<Employee> employee= repo.findById(id);
		if (employee.isPresent()) {
			Employee employee1=employee.get();
			employee1.setAddress(address);
			return repo.save(employee1);
		} else {
			return null;
		}
	}
	
	public Employee updateEmail(int id, String email) {
		Optional<Employee> employee= repo.findById(id);
		if (employee.isPresent()) {
			Employee employee1=employee.get();
			employee1.setEmail(email);
			return repo.save(employee1);
		} else {
			return null;
		}
	}
	
	public Employee updateDesignation(int id, String designation) {
		Optional<Employee> employee= repo.findById(id);
		if (employee.isPresent()) {
			Employee employee1=employee.get();
			employee1.setDesignation(designation);
			return repo.save(employee1);
		} else {
			return null;
		}
	}
	
	public Employee updatePassword(int id, String password) {
		Optional<Employee> employee= repo.findById(id);
		if (employee.isPresent()) {
			Employee employee1=employee.get();
			employee1.setPassword(password);
			return repo.save(employee1);
		} else {
			return null;
		}
	}
	
	public Employee updatePassword(long phone, String password) {
		Employee employee= repo.findByPhone(phone);
		if (employee!=null) {
			employee.setPassword(password);
			return repo.save(employee);
		} else {
			return null;
		}
	}
	
	public Employee updatePassword(String email, String password) {
		Employee employee= repo.getByEmail(email);
		if (employee!=null) {
			employee.setPassword(password);
			return repo.save(employee);
		} else {
			return null;
		}
	}
	
	public Employee updateAll(int id ,Employee employee) {
		Optional<Employee> employee2=repo.findById(id);
		if (employee2.isPresent()) {
			employee.setId(id);
			return repo.save(employee);
		} else {
			return null;
		}
	}
	
	public Employee deleteEmployee(int id) {
		Optional<Employee> employee=repo.findById(id);
		if (employee.isPresent()) {
			repo.deleteById(id);
			return employee.get();
		} else {
			return null;
		}
	}
	
	
	public void deleteEmployee(Employee employee) 
	{
		repo.delete(employee);
		
	}
		
	
	public void deleteAllEmployee() {
		repo.deleteAll();
		
	}
	
	public List<Employee> deleteAllEmployeeByAddress(String address) {
		List<Employee>list=repo.findByAddress(address);
		if (list.isEmpty()) {
			return list;
		} else {
			repo.deleteAll(list);
			return list;
		}
	}
	
	public List<Employee> deleteAllEmployeeByDesignation(String designation) {
		List<Employee>list=repo.findByDesignation(designation);
		if (list.isEmpty()) {
			return list;
		} else {
			repo.deleteAll(list);
			return list;
		}
	}
	
	public List<Employee> deleteAllEmployeeByName(String name) {
		List<Employee>list=repo.findByName(name);
		System.out.println(list);
		if (list.isEmpty()) {
			return list;
		} else {
			repo.deleteAll(list);
			return list;
		}
	}

	

	
}
