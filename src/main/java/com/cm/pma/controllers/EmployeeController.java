package com.cm.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cm.pma.dao.EmployeeRepository;
import com.cm.pma.entities.Employee;
import com.cm.pma.entities.Project;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepo;
	@GetMapping("/new")
	public String employeeForm(Model model)
	{
		model.addAttribute("employee",new Employee());
		return "employee";
	}

@GetMapping("/list")
public String listEmployeeForm(Model model) {
	List<Employee> employee=employeeRepo.findAll();
	 model.addAttribute("employees",employee);
	
	
	return "list-employees";
	
}
	@PostMapping("/save")
	public String employeeForm(Model model,Employee employee)
	{
		employeeRepo.save(employee);
		return "redirect:/employees/list";
	}

}
