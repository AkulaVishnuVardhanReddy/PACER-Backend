package com.Backend.PACER.entities;

import java.time.LocalDate;
import java.util.Arrays;

import jakarta.persistence.*;

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


    private String imageName;
    private String imageType;

    @Lob
	private byte[] photo;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="role_id")
	private Role role;
	private String username;
	private String password;
	private String questionAns1;
	private String questionAns2;
	
//	Empty Constructor
	public User() {
		
	}
	
	
//	Constructor

	public User(Long id, String firstName, String lastName, LocalDate dob, String emailId, long phoneNo, String imageName, String imageType, byte[] photo, Role role, String username, String password, String questionAns1, String questionAns2) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.imageName = imageName;
		this.imageType = imageType;
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

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public String getEmailId() {
		return emailId;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public String getImageName() {
		return imageName;
	}

	public String getImageType() {
		return imageType;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public Role getRole() {
		return role;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getQuestionAns1() {
		return questionAns1;
	}

	public String getQuestionAns2() {
		return questionAns2;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setQuestionAns1(String questionAns1) {
		this.questionAns1 = questionAns1;
	}

	public void setQuestionAns2(String questionAns2) {
		this.questionAns2 = questionAns2;
	}


//	ToString

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", dob=" + dob +
				", emailId='" + emailId + '\'' +
				", phoneNo=" + phoneNo +
				", imageName='" + imageName + '\'' +
				", imageType='" + imageType + '\'' +
				", photo=" + Arrays.toString(photo) +
				", role=" + role +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", questionAns1='" + questionAns1 + '\'' +
				", questionAns2='" + questionAns2 + '\'' +
				'}';
	}
}
