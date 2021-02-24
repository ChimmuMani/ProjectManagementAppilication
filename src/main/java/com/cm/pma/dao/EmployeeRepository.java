package com.cm.pma.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cm.pma.dto.EmployeeProject;
import com.cm.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
	@Override
	public List<Employee> findAll();
	@Query(nativeQuery=true,value="Select first_name as FirstName,last_name as LastName,count(pe.employee_id) as  projectCount from employee e join project_employee pe on e.employee_id=pe.employee_id GROUP BY first_name,last_name order by 3 desc")
	public List<EmployeeProject> employeeProjects();
}
