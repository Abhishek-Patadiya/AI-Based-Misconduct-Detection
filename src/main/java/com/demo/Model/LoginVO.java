package com.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Login")
public class LoginVO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="LoginID")
	private int loginId;
	
	@Column(name="Username")
	private String username;
	
	@Column(name="Password")
	private String password;
	

	@Column(name="Enable")
	private int enabled;
	

	@Column(name="Role")
	private String role;


	public int getLoginId() {
		return loginId;
	}


	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getEnabled() {
		return enabled;
	}


	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}




				
}
