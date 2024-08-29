package com.kosta.domain;

public enum UserRole {
	MEMBER("ROLE_MEMBER"),
	LEADER("ROLE_LEADER");
	
	String role;
	
	UserRole(String role){
		this.role=role;
		
	}
	
	public String getRole() {
		return role;
	}
}
