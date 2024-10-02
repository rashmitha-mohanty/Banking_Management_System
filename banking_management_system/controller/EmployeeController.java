package com.qsp.banking_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.banking_management_system.dto.Employee;
import com.qsp.banking_management_system.service.EmployeeService;
import com.qsp.banking_management_system.util.ResponseStructure;
import com.qsp.banking_management_system.util.ResponseStructureList;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/saveEmployee")
	public ResponseStructure<Employee> saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@GetMapping("/fetchEmployeeById")
	public ResponseStructure<Employee> fetchEmployeeById(@RequestParam int employeeId) {
		return employeeService.fetchEmployeeById(employeeId);
	}
	
	@DeleteMapping("/deleteEmployeeById")
	public ResponseStructure<Employee> deleteEmployeeById(@RequestParam int employeeId) {
         return employeeService.deleteEmployeeById(employeeId);
	}
	
	@PutMapping("/updateEmployee")
	public ResponseStructure<Employee> updateEmployee(@RequestParam int oldId,@RequestBody Employee newEmployee) {
		 return employeeService.updateEmployee(oldId, newEmployee);
	}
	
	@GetMapping("/fetchAllEmployee")
	public ResponseStructureList<Employee> fetchAllEmployee() {
		return employeeService.fetchAllEmployee();
	}
}
