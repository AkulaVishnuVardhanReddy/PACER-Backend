package com.Backend.PACER.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ScheduleSlot {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="court_case_cin",nullable=false)
	private CourtCase courtcase;
	
	private LocalDate date;
	private boolean booked;
	
//	Empty Constructor
	public ScheduleSlot() {
		
	}

	
//	Constructor
	public ScheduleSlot(long id, CourtCase courtcase, LocalDate date, boolean booked) {
		super();
		this.id = id;
		this.courtcase = courtcase;
		this.date = date;
		this.booked = booked;
	}


	
//	Getters and Setters
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public CourtCase getCourtcase() {
		return courtcase;
	}


	public void setCourtcase(CourtCase courtcase) {
		this.courtcase = courtcase;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public boolean isBooked() {
		return booked;
	}


	public void setBooked(boolean booked) {
		this.booked = booked;
	}


	
//	toString method
	@Override
	public String toString() {
		return "ScheduleSlot [id=" + id + ", courtcase=" + courtcase + ", date=" + date + ", booked=" + booked + "]";
	}
	
	
	
}
