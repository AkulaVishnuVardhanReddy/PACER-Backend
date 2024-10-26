package com.Backend.PACER.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Hearing {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name ="court_case_cin" , nullable = false)
	private CourtCase courtCase;
	
	private LocalDate hearingDate;
	private String adjournmentReason;
	private String procedingSummary;
	private LocalDate nextHearingDate;
	
//	Empty Constructor
	public Hearing() {
		
	}
	
	
//	Constructor
	public Hearing(long id, CourtCase courtCase, LocalDate hearingDate, String adjournmentReason,
			String procedingSummary, LocalDate nextHearingDate) {
		super();
		this.id = id;
		this.courtCase = courtCase;
		this.hearingDate = hearingDate;
		this.adjournmentReason = adjournmentReason;
		this.procedingSummary = procedingSummary;
		this.nextHearingDate = nextHearingDate;
	}


//	Getters and Setters
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public CourtCase getCourtCase() {
		return courtCase;
	}


	public void setCourtCase(CourtCase courtCase) {
		this.courtCase = courtCase;
	}


	public LocalDate getHearingDate() {
		return hearingDate;
	}


	public void setHearingDate(LocalDate hearingDate) {
		this.hearingDate = hearingDate;
	}


	public String getAdjournmentReason() {
		return adjournmentReason;
	}


	public void setAdjournmentReason(String adjournmentReason) {
		this.adjournmentReason = adjournmentReason;
	}


	public String getProcedingSummary() {
		return procedingSummary;
	}


	public void setProcedingSummary(String procedingSummary) {
		this.procedingSummary = procedingSummary;
	}


	public LocalDate getNextHearingDate() {
		return nextHearingDate;
	}


	public void setNextHearingDate(LocalDate nextHearingDate) {
		this.nextHearingDate = nextHearingDate;
	}


//	toString Method
	@Override
	public String toString() {
		return "Hearing [id=" + id + ", courtCase=" + courtCase + ", hearingDate=" + hearingDate
				+ ", adjournmentReason=" + adjournmentReason + ", procedingSummary=" + procedingSummary
				+ ", nextHearingDate=" + nextHearingDate + "]";
	}
	
	
	
	
}
