package com.cm.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cm.pma.dao.EmployeeRepository;
import com.cm.pma.dao.ProjectRepository;
import com.cm.pma.dto.EmployeeProject;
import com.cm.pma.entities.Employee;
import com.cm.pma.entities.Project;

@Controller
public class HomeController {
	@Autowired
	private ProjectRepository projectrepo;
	@Autowired
	private EmployeeRepository employeeRepo;
@GetMapping("/")
public String playHome(Model model) {
	List<Project> project=projectrepo.findAll();
	model.addAttribute("project",project);
	List<EmployeeProject> employee=employeeRepo.employeeProjects();
	 model.addAttribute("employees",employee);
	return "home";
	
}
}
