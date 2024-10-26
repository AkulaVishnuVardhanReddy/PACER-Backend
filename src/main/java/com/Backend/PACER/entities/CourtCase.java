package com.Backend.PACER.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CourtCase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cin;
	
	private String defendentName;
	private String defendentAddress;
	private String crimeType;
	private LocalDate crimeDate;
	private String crimeLocation;
	private String arrestingOfficerName;
	private String arrestDate;
	private String judgeName;
	private String publicProsecutorName;
	private String lawyerName;
	private String courtName;
	private LocalDate startDate;
	private LocalDate expectedCompletionDate;
	private String status;
	
//	Empty Constructor
	public CourtCase() {
		
	}
	
	
//	Constructor
	public CourtCase(long cin, String defendentName, String defendentAddress, String crimeType, LocalDate crimeDate,
			String crimeLocation, String arrestingOfficerName, String arrestDate, String judgeName,
			String publicProsecutorName, String lawyerName, String courtName, LocalDate startDate,
			LocalDate expectedCompletionDate, String status) {
		super();
		this.cin = cin;
		this.defendentName = defendentName;
		this.defendentAddress = defendentAddress;
		this.crimeType = crimeType;
		this.crimeDate = crimeDate;
		this.crimeLocation = crimeLocation;
		this.arrestingOfficerName = arrestingOfficerName;
		this.arrestDate = arrestDate;
		this.judgeName = judgeName;
		this.publicProsecutorName = publicProsecutorName;
		this.lawyerName = lawyerName;
		this.courtName = courtName;
		this.startDate = startDate;
		this.expectedCompletionDate = expectedCompletionDate;
		this.status = status;
	}


//	Getters and Setters
	public long getCin() {
		return cin;
	}


	public void setCin(long cin) {
		this.cin = cin;
	}


	public String getDefendentName() {
		return defendentName;
	}


	public void setDefendentName(String defendentName) {
		this.defendentName = defendentName;
	}


	public String getDefendentAddress() {
		return defendentAddress;
	}


	public void setDefendentAddress(String defendentAddress) {
		this.defendentAddress = defendentAddress;
	}


	public String getCrimeType() {
		return crimeType;
	}


	public void setCrimeType(String crimeType) {
		this.crimeType = crimeType;
	}


	public LocalDate getCrimeDate() {
		return crimeDate;
	}


	public void setCrimeDate(LocalDate crimeDate) {
		this.crimeDate = crimeDate;
	}


	public String getCrimeLocation() {
		return crimeLocation;
	}


	public void setCrimeLocation(String crimeLocation) {
		this.crimeLocation = crimeLocation;
	}


	public String getArrestingOfficerName() {
		return arrestingOfficerName;
	}


	public void setArrestingOfficerName(String arrestingOfficerName) {
		this.arrestingOfficerName = arrestingOfficerName;
	}


	public String getArrestDate() {
		return arrestDate;
	}


	public void setArrestDate(String arrestDate) {
		this.arrestDate = arrestDate;
	}


	public String getJudgeName() {
		return judgeName;
	}


	public void setJudgeName(String judgeName) {
		this.judgeName = judgeName;
	}


	public String getPublicProsecutorName() {
		return publicProsecutorName;
	}


	public void setPublicProsecutorName(String publicProsecutorName) {
		this.publicProsecutorName = publicProsecutorName;
	}


	public String getLawyerName() {
		return lawyerName;
	}


	public void setLawyerName(String lawyerName) {
		this.lawyerName = lawyerName;
	}


	public String getCourtName() {
		return courtName;
	}


	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getExpectedCompletionDate() {
		return expectedCompletionDate;
	}


	public void setExpectedCompletionDate(LocalDate expectedCompletionDate) {
		this.expectedCompletionDate = expectedCompletionDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


//	ToString Method
	@Override
	public String toString() {
		return "CourtCase [cin=" + cin + ", defendentName=" + defendentName + ", defendentAddress=" + defendentAddress
				+ ", crimeType=" + crimeType + ", crimeDate=" + crimeDate + ", crimeLocation=" + crimeLocation
				+ ", arrestingOfficerName=" + arrestingOfficerName + ", arrestDate=" + arrestDate + ", judgeName="
				+ judgeName + ", publicProsecutorName=" + publicProsecutorName + ", lawyerName=" + lawyerName
				+ ", courtName=" + courtName + ", startDate=" + startDate + ", expectedCompletionDate="
				+ expectedCompletionDate + ", status=" + status + "]";
	}
	
	
	
	
	
}
