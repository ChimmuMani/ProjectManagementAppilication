package com.cm.pma.dto;

public interface EmployeeProject {
	//Dto to populate data from table using customs query
//Need to have proprtyNames begin with get
	public String getFirstName();
	public String getLastName();
	public int getProjectCount();
}
