package jp.co.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sample.domain.Employee;
import jp.co.sample.repository.EmployeeRepository;

@Controller

public class EmployeeControllerSample {
	@Autowired
	private EmployeeRepository repository;
	
	@RequestMapping("/sample2")
	public String sample2() {
		Employee employee = new Employee();
		
		repository.findAll().forEach(System.out::println);
		repository.load(5);
		repository.update(employee);
		
		return "sample-result";
	}

}
