package com.microservices.OrganizationService.response;

public class Employee {

    private Long id;
    private String name;
    private String email;
    private Long departmentId;
    
    	
    public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Long id, String name, String email, Long departmentId) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.departmentId = departmentId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

    
    
    
}
