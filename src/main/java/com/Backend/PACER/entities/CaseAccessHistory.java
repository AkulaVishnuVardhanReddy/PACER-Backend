package com.Backend.PACER.entities;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CaseAccessHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name="court_case_cin",nullable=false)
	private CourtCase courtCase;
	
	private LocalTime accessTime;
	private double charge;
	
	
	
//	Empty Constructor
	public CaseAccessHistory() {
		
	}


//	Constructor
	public CaseAccessHistory(long id, User user, CourtCase courtCase, LocalTime accessTime, double charge) {
		super();
		this.id = id;
		this.user = user;
		this.courtCase = courtCase;
		this.accessTime = accessTime;
		this.charge = charge;
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


	public CourtCase getCourtCase() {
		return courtCase;
	}


	public void setCourtCase(CourtCase courtCase) {
		this.courtCase = courtCase;
	}


	public LocalTime getAccessTime() {
		return accessTime;
	}


	public void setAccessTime(LocalTime accessTime) {
		this.accessTime = accessTime;
	}


	public double getCharge() {
		return charge;
	}


	public void setCharge(double charge) {
		this.charge = charge;
	}


//	toString Method
	@Override
	public String toString() {
		return "CaseAccessHistory [id=" + id + ", user=" + user + ", courtCase=" + courtCase + ", accessTime="
				+ accessTime + ", charge=" + charge + "]";
	}	
}
