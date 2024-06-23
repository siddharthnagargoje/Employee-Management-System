package com.qsp.employee_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.employee_management_system.dao.EmployeeDao;
import com.qsp.employee_management_system.dto.Employee;
import com.qsp.employee_management_system.service.EmployeeService;
import com.qsp.employee_management_system.util.ResponseStructure;

@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee) 
	{
		return service.saveEmployee(employee);	
	}
	
	@PostMapping("/save/all")
	public ResponseEntity<ResponseStructure<List<Employee>>> saveAllEmployee(@RequestBody List<Employee> employees) {
		return service.saveAllEmployee(employees);
	}
	
	@GetMapping("/find/id")
	public ResponseEntity<ResponseStructure<Employee>> findEmployeeById( @RequestParam int id) {
		return service.findEmployeeById(id);
	}
	
	@GetMapping("/find/name")
	public ResponseEntity<ResponseStructure<List<Employee>>> findEmployeeByName( @RequestParam String name ){
		return service.findEmployeeByName(name);
	}
	
	@GetMapping("/find/phone")
	public ResponseEntity<ResponseStructure<Employee>> findEmployeeByPhone(@RequestParam long phone) {
		return service.findEmployeeByPhone(phone);
	}
	
	@GetMapping("/find/email")
	public ResponseEntity<ResponseStructure<Employee>> findEmployeeByEmail(@RequestParam String email) {
		return service.findEmployeeByEmail(email);
	}
	
	@GetMapping("/find/address")
	public ResponseEntity<ResponseStructure<List<Employee>>> findEmployeeByAddress(@RequestParam String address) {
		return service.findEmployeeByAddress(address);
	}
	
	@GetMapping("/find/designation")
	public ResponseEntity<ResponseStructure<List<Employee>>> findEmployeeByDesignation(@RequestParam String designation) {
		return service.findByEmployeeDesignation(designation);
	}
	
	@GetMapping("/find/all")
	public ResponseEntity<ResponseStructure<List<Employee>>> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/find/salary/less")
	public ResponseEntity<ResponseStructure<List<Employee>>> salaryLessThan(@RequestParam double salary) {
		return service.salaryLessThan(salary);
	}
	
	@GetMapping("/find/salary/greater")
	public ResponseEntity<ResponseStructure<List<Employee>>> salaryGreaterThan(@RequestParam double salary) {
		return service.salaryGreaterThan(salary);
	}
	
	@GetMapping("/find/salary/between")
	public ResponseEntity<ResponseStructure<List<Employee>>> salaryBetween(@RequestParam double salary1 ,@RequestParam double salary2) {
		return service.salaryBetween(salary1, salary2);
	}
	
	@PatchMapping("/update/name")
	public ResponseEntity<ResponseStructure<Employee>> updateName(@RequestParam int id , @RequestParam String name ) {
		return service.updateName(id, name);
	}
	
	@PatchMapping("/update/phone")
	public ResponseEntity<ResponseStructure<Employee>> updatePhone(@RequestParam int id , @RequestParam long phone ) {
		return service.updatePhone(id, phone);
	}
	
	@PatchMapping("/update/address")
	public ResponseEntity<ResponseStructure<Employee>> updateAddress(@RequestParam int id , @RequestParam String address ) {
		return service.updateAddress(id, address);
	}
	
	@PatchMapping("/update/email")
	public ResponseEntity<ResponseStructure<Employee>> updateEmail(@RequestParam int id , @RequestParam String email ) {
		return service.updateEmail(id, email);
	}
	
	@PatchMapping("/update/designation")
	public ResponseEntity<ResponseStructure<Employee>> updateDesignation(@RequestParam int id , @RequestParam String designation ) {
		return service.updateDesignation(id, designation);
	}
	
	@PatchMapping("/update/password/id")
	public ResponseEntity<ResponseStructure<Employee>> updatePassword(@RequestParam int id , @RequestParam String password ) {
		return service.updatePassword(id, password);
	}
	
	@PatchMapping("/update/password/phone")
	public ResponseEntity<ResponseStructure<Employee>> updatePassword(@RequestParam long phone , @RequestParam String password ) {
		return service.updatePassword(phone, password);
	}
	
	@PatchMapping("/update/password/email")
	public ResponseEntity<ResponseStructure<Employee>> updatePassword(@RequestParam String email , @RequestParam String password ) {
		return service.updatePassword(email, password);
	}
	
	@PutMapping("/update/all")
	public ResponseEntity<ResponseStructure<Employee>> updateAll(@RequestParam int id ,@RequestBody Employee employee) {
		return service.updateAll(id, employee);
	}
	
	@DeleteMapping("/delete/id")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(@RequestParam int id) {
		return service.deleteEmployee(id);
	}
	
	@DeleteMapping("/delete/phone")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(@RequestParam long phone) {
		return service.deleteEmployee(phone);
	}
	
	@DeleteMapping("/delete/email")
	public ResponseEntity<ResponseStructure<Employee>> deleteEmployee(@RequestParam String email) {
		return service.deleteEmployee(email);
	}
	
	
	@DeleteMapping("/delete/all/address")
	public ResponseEntity<ResponseStructure<List<Employee>>> deleteAllEmployeeByAddress(@RequestParam String address) {
		return service.deleteAllEmployeeByAddress(address);
	}
	
	@DeleteMapping("/delete/all/designation")
	public ResponseEntity<ResponseStructure<List<Employee>>> deleteAllEmployeeByDesignation(@RequestParam String designation) {
		return service.deleteAllEmployeeByDesignation(designation);
	}
	
	@DeleteMapping("/delete/all/name")
	public ResponseEntity<ResponseStructure<List<Employee>>> deleteAllEmployeeByName(@RequestParam String name) {
		return service.deleteAllEmployeeByName(name);
	}
	
	@DeleteMapping("/delete/all")
	public ResponseEntity<ResponseStructure<List<Employee>>> deleteAllEmployee() {
		return service.deleteAllEmployee();
	}
	
	
	@GetMapping("/login")
	public String login(@RequestParam String userName,@RequestParam String password) 
	{
		return service.login(userName,password);
	}
	
}
