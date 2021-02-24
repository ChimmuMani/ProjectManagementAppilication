package com.cm.pma.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cm.pma.dao.EmployeeRepository;
import com.cm.pma.dao.ProjectRepository;
import com.cm.pma.entities.Employee;
import com.cm.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	private ProjectRepository projectRepo;
	@Autowired
	private EmployeeRepository empRepo;
	@GetMapping("/new")
	public String displayForm(Model model) {
		List<Employee> employees=empRepo.findAll();
		model.addAttribute("project",new Project());	
		model.addAttribute("allemployees",employees);	
		return "new-project" ;
	}
	@GetMapping("/list")
	public String listProjectForm(Model model) {
		List<Project> project=projectRepo.findAll();
		model.addAttribute("projects",project);
		return "list-projects";

	}
	@PostMapping("/save")
	public String createProject(Project project,Model model,/*@RequestParam("employees") List<Long> pid,*/ RedirectAttributes reAttr) {
		projectRepo.save(project);
//		Iterable<Employee> eid=empRepo.findAllById(pid);
//		for(Employee id:eid) {
//			id.setProjectId(project);
//			empRepo.save(id);
//		}
		return "redirect:/projects/list";

	}

}

