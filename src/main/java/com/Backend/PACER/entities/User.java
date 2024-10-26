package com.Backend.PACER.entities;

import java.time.LocalDate;
import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String emailId;
	private long phoneNo;
	private byte[] photo;
	
	private String role;
	private String username;
	private String password;
	private String questionAns1;
	private String questionAns2;
	
//	Empty Constructor
	public User() {
		
	}
	
	
//	Constructor
	public User(Long id, String firstName, String lastName, LocalDate dob, String emailId, long phoneNo, byte[] photo,
			String role, String username, String password, String questionAns1, String questionAns2) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.photo = photo;
		this.role = role;
		this.username = username;
		this.password = password;
		this.questionAns1 = questionAns1;
		this.questionAns2 = questionAns2;
	}

	
	
//	Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
	public String getQuestionAns1() {
		return questionAns1;
	}
	public void setQuestionAns1(String questionAns1) {
		this.questionAns1 = questionAns1;
	}
	public String getQuestionAns2() {
		return questionAns2;
	}
	public void setQuestionAns2(String questionAns2) {
		this.questionAns2 = questionAns2;
	}
	
	
//	To String Method
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", emailId="
				+ emailId + ", phoneNo=" + phoneNo + ", photo=" + Arrays.toString(photo) + ", role=" + role
				+ ", username=" + username + ", password=" + password + ", questionAns1=" + questionAns1
				+ ", questionAns2=" + questionAns2 + "]";
	}	
}
