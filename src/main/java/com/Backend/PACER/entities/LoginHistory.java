package com.Backend.PACER.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LoginHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable = false)
	private User user;
	
	private LocalDateTime loginTime;
	private LocalDateTime logoutTime;
	
	
//	Empty Constructor
	public LoginHistory() {
		
	}
	
	
//	Constructor
	public LoginHistory(long id, User user, LocalDateTime loginTime, LocalDateTime logoutTime) {
		super();
		this.id = id;
		this.user = user;
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
	}


//	Getters and Setters
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public LocalDateTime getLoginTime() {
		return loginTime;
	}


	public void setLoginTime(LocalDateTime loginTime) {
		this.loginTime = loginTime;
	}


	public LocalDateTime getLogoutTime() {
		return logoutTime;
	}


	public void setLogoutTime(LocalDateTime logoutTime) {
		this.logoutTime = logoutTime;
	}


//	toString Method
	@Override
	public String toString() {
		return "LoginHistory [id=" + id + ", user=" + user + ", loginTime=" + loginTime + ", logoutTime=" + logoutTime
				+ "]";
	}
	
	
	
}
