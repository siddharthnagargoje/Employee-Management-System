package com.qsp.employee_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.qsp.employee_management_system.dao.EmployeeDao;
import com.qsp.employee_management_system.dto.Employee;
import com.qsp.employee_management_system.exception.AddressNotFoundException;
import com.qsp.employee_management_system.exception.EmailNotFoundException;
import com.qsp.employee_management_system.exception.IdNotFoundException;
import com.qsp.employee_management_system.exception.IncorrectPasswordException;
import com.qsp.employee_management_system.exception.NoDataFoundException;
import com.qsp.employee_management_system.exception.PhoneNumberNotFoundException;
import com.qsp.employee_management_system.util.ResponseStructure;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao dao;

	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(Employee employee) {

		double salary = employee.getSalary();
		if (salary <= 10000) {
			employee.setGrade('D');
		} else if (salary > 10000 && salary <= 20000) {
			employee.setGrade('C');
		} else if (salary > 20000 && salary <= 40000) {
			employee.setGrade('B');
		} else {
			employee.setGrade('A');
		}
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setMessage("Saved Successfully");
		structure.setData(dao.saveEmployee(employee));
		return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<List<Employee>>> saveAllEmployee(List<Employee> employees) {
		for (Employee employee : employees) {

			double salary = employee.getSalary();
			if (salary <= 10000) {
				employee.setGrade('D');
			} else if (salary > 10000 && salary <= 20000) {
				employee.setGrade('C');
			} else if (salary > 20000 && salary <= 40000) {
				employee.setGrade('B');
			} else {
				employee.setGrade('A');
			}
		}
		List<Employee> list = dao.saveAllEmployee(employees);
		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();

		if (list.isEmpty()) {
			throw new NoDataFoundException("List is empty");
		}
		else 
		{
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setMessage("Saved Successfully");
			structure.setData(list);

			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.CREATED);

		
		}
	}

	public ResponseEntity<ResponseStructure<Employee>> findEmployeeById(int id) {
		Employee employee = dao.findEmployeeById(id);
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();

		if (employee != null) {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Found Successfully");
			structure.setData(employee);

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);
		} else {

			throw new IdNotFoundException("Employee with id" + id + "not found");
		}
	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findEmployeeByName(String name) {
		List<Employee> list = dao.findEmployeeByName(name);

		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();

		if (list.isEmpty()) {
			throw new NoDataFoundException("employee with Name" + name + "not found");
		} 
		else 
		{
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage(" Found Sucessfully");
			structure.setData(list);

			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<Employee>> findEmployeeByPhone(long phone) {
		Employee employee = dao.findByPhone(phone);

		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();

		if (employee != null) {
		
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Found Successfully");
			structure.setData(employee);

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);
		} else 
		{
			throw new PhoneNumberNotFoundException("Employee with Phone" + phone + "not found");
		}

	}

	public ResponseEntity<ResponseStructure<Employee>> findEmployeeByEmail(String email) {
		Employee employee = dao.findByEmail(email);

		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();

		if (employee != null) {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Found Successfully");
			structure.setData(employee);

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.FOUND);
		} else {
			throw new EmailNotFoundException("Employee with Email" + email + "not found");
		}

	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findEmployeeByAddress(String address) {
		List<Employee> list = dao.findByAddress(address);

		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();

		if (list.isEmpty()) {
		
			throw new AddressNotFoundException("employee with Address" + address + "not found");
		} else {
			
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Found Successfully");
			structure.setData(list);

			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.FOUND);

			
		}

	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findByEmployeeDesignation(String designation) {
		List<Employee> list = dao.findByDesignation(designation);

		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();

		if (list.isEmpty()) {
			throw new NoDataFoundException("employee with designation" + designation + "not found");
		} else {
			
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Found Successfully");
			structure.setData(list);

			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.FOUND);
	
		}
		
	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findAll() {
		List<Employee> employees = dao.findAll();
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();

		if (employees.isEmpty()) {
			throw new NoDataFoundException("Employees Details not found");
			
		} 
		else {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Found Successfully");
			structure.setData(employees);

			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.FOUND);
		}
	}

	public ResponseEntity<ResponseStructure<List<Employee>>> salaryLessThan(double salary) {
		List<Employee> list = dao.salaryLessThan(salary);

		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();

		if (list.isEmpty()) {
			throw new NoDataFoundException("Employees Salary Less Than " + salary + " not found");
		} else {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Found Successfully");
			structure.setData(list);

			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.FOUND);

		}

	}

	public ResponseEntity<ResponseStructure<List<Employee>>> salaryGreaterThan(double salary) {
		List<Employee> list = dao.salaryGreaterThan(salary);

		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();

		if (list.isEmpty()) {
			throw new NoDataFoundException("Employees Salary Greater Than " + salary + " not found");
		} else {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Found Successfully");
			structure.setData(list);

			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.FOUND);

		}

	}

	public ResponseEntity<ResponseStructure<List<Employee>>> salaryBetween(double salary1, double salary2) {
		List<Employee> list = dao.salaryBetween(salary1, salary2);

		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();

		if (list.isEmpty()) {
			throw new NoDataFoundException("Employees Salary between" + salary1 + "to" + salary2 + "not found");
		} else {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("Found Successfully");
			structure.setData(list);

			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.FOUND);
		
		}

	}

	public ResponseEntity<ResponseStructure<Employee>> updateName(int id, String name) {
		Employee employee = dao.updateName(id, name);

		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();

		if (employee != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Data Updated Successfully");
			structure.setData(employee);

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Employee with id" + id + "not found");

		}

	}

	public ResponseEntity<ResponseStructure<Employee>> updatePhone(int id, long phone) {
		Employee employee = dao.updatePhone(id, phone);

		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();

		if (employee != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Data Updated Successfully");
			structure.setData(employee);

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Employee with id" + id + "not found");

		}

	}

	public ResponseEntity<ResponseStructure<Employee>> updateAddress(int id, String address) {
		Employee employee = dao.updateAddress(id, address);

		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();

		if (employee != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Data Updated Successfully");
			structure.setData(employee);

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Employee with id" + id + "not found");

		}

	}

	public ResponseEntity<ResponseStructure<Employee>> updateEmail(int id, String email) {
		Employee employee = dao.updateEmail(id, email);

		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();

		if (employee != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Data Updated Successfully");
			structure.setData(employee);

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Employee with id" + id + "not found");

		}

	}

	public ResponseEntity<ResponseStructure<Employee>> updateDesignation(int id, String designation) {
		Employee employee = dao.updateDesignation(id, designation);

		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();

		if (employee != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Data Updated Successfully");
			structure.setData(employee);

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Employee with id" + id + "not found");

		}

	}

	public ResponseEntity<ResponseStructure<Employee>> updatePassword(int id, String password) {
		Employee employee = dao.updatePassword(id, password);

		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();

		if (employee != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Data Updated Successfully");
			structure.setData(employee);

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Employee with id" + id + "not found");
		}

	}

	public ResponseEntity<ResponseStructure<Employee>> updatePassword(long phone, String password) {
		Employee employee = dao.updatePassword(phone, password);

		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();

		if (employee != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Data Updated Successfully");
			structure.setData(employee);

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
		} else {
			throw new PhoneNumberNotFoundException("Employee with Phone" + phone + "not found");

		}
	}

	public ResponseEntity<ResponseStructure<Employee>> updatePassword(String email, String password) {
		Employee employee = dao.updatePassword(email, password);

		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();

		if (employee != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Data Updated Successfully");
			structure.setData(employee);

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
		} else {
			throw new EmailNotFoundException("Employee with Email" + email + "not found");

		}
	}

	public ResponseEntity<ResponseStructure<Employee>> updateAll(int id, Employee employee) {
		Employee employee2 = dao.updateAll(id, employee);

		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();

		if (employee2 != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Data Updated Successfully");
			structure.setData(employee2);

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Employee with id" + id + "not found");

		}
	}

	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(int id) {
		Employee employee = dao.deleteEmployee(id);

		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();

		if (employee != null) {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Delete Successfully");
			structure.setData(employee);

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Employee with id" + id + "not found");

		}

	}

	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(long phone) {
		Employee employee = dao.findByPhone(phone);

		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();

		if (employee != null) 
		{
			dao.deleteEmployee(employee);
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Delete Successfully");
			structure.setData(employee);

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
		} else {
			throw new PhoneNumberNotFoundException("Employee with Phone" + phone + "not found");

		}

	}

	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(String email) {
		Employee employee = dao.findByEmail(email);
  
		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();

		if (employee != null) {
			dao.deleteEmployee(employee); 
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Delete Successfully");
			structure.setData(employee);

			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
		} else {
			throw new EmailNotFoundException("Employee with Email" + email + "not found");

		}

	}

	public ResponseEntity<ResponseStructure<List<Employee>>> deleteAllEmployeeByAddress(String address) {
		List<Employee> list = dao.deleteAllEmployeeByAddress(address);

		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();

		if (list.isEmpty()) {
			throw new NoDataFoundException("employee with Address" + address + "not found");
		} else {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Deleted Successfully");
			structure.setData(list);

			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.OK);

			

		}

	}

	public ResponseEntity<ResponseStructure<List<Employee>>> deleteAllEmployeeByDesignation(String designation) {
		List<Employee> list = dao.deleteAllEmployeeByDesignation(designation);

		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();

		if (list.isEmpty()) {
			throw new NoDataFoundException("employee with designation" + designation + "not found");
		} else {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Deleted Successfully");
			structure.setData(list);

			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.OK);

		

		}

	}

	public ResponseEntity<ResponseStructure<List<Employee>>> deleteAllEmployeeByName(String name) {
		List<Employee> list = dao.deleteAllEmployeeByName(name);

		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();

		if (list.isEmpty()) {
			throw new NoDataFoundException("employee with Name" + name + "not found");
		} else {
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Deleted Successfully");
			structure.setData(list);

			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.OK);

		

		}

	}

	public ResponseEntity<ResponseStructure<List<Employee>>> deleteAllEmployee() {
		List<Employee> list = dao.findAll();

		ResponseStructure<List<Employee>> structure = new ResponseStructure<List<Employee>>();

		if (list.isEmpty()) {
			throw new NoDataFoundException("List is empty");
		} else {
			dao.deleteAllEmployee();
			structure.setStatus(HttpStatus.OK.value());
			structure.setMessage("Deleted Successfully");
			structure.setData(list);

			return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.OK);
		}

	}

	public String login(String userName, String password) {

		ResponseStructure<Employee> structure = new ResponseStructure<Employee>();
		try {
			long phone = Long.parseLong(userName);
			Employee employee = dao.findByPhone(phone);

			if (employee != null) {
				if (employee.getPassword().equals(password)) {
                        return "login successfully";
                        
				} else {
					return "Inccorrect Password";
				}

			} else {
				throw new PhoneNumberNotFoundException("Employee with Phone" + phone + "not found");
			}
		} catch (NumberFormatException e) {
			String email = userName;
			Employee employee = dao.findByEmail(email);
			if (employee != null) {
				if (employee.getPassword().equals(password)) {
					return "login successfully";
				
				} else {
				  return "Inccorrect Password";
				}
			} else {
				throw new EmailNotFoundException("Employee with Email" + email + "not found");
			}
		}

	}

}
