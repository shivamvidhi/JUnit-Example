package com.example.JUnit.Example.service;

import com.example.JUnit.Example.EmployeeService;
import com.example.JUnit.Example.models.Address;
import com.example.JUnit.Example.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class JUnitExampleApplication {

	@Autowired
	static EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(JUnitExampleApplication.class, args);

		employeeService.empList = new ArrayList<>();
		employeeService.employeeSet = new HashSet<>();
		employeeService.employeeHashMap = new HashMap<>();

		Employee employeeToAdd = new Employee();
		employeeToAdd.setId(123456789);
		employeeToAdd.setFirstName("Vidhi");
		employeeToAdd.setLastName("Tyagi");
		Address addressVidhi = new Address();
		addressVidhi.setCity("Meerut");
		addressVidhi.setCountry("India");
		addressVidhi.setPincode(250001);
		addressVidhi.setAddress("Shradhapuri");
		employeeToAdd.setAddress(addressVidhi);

		//we can create more employees and adresses like above

		// call our methods
		employeeService.insertEmployee(employeeToAdd);
		employeeService.updateEmployee(employeeToAdd);
		List<Employee> listOfEmployees = employeeService.getAllEmployees();
		Employee employee = employeeService.getEmployeeById(123456789);
		employeeService.deleteEmployee(123456789);


		System.out.println(employee);
		System.out.println(listOfEmployees);
	}

}
