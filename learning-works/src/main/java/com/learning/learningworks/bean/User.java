package com.learning.learningworks.bean;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;

public class User {
	@Id
	private Integer userId;
	private String userEmail;
	private String userPassword;
	private String userFName;
	private String userLName;
	private String userGender;
	private LocalDate userDOB;
	private List<String> userCC;
	private String userCountry;
	private String userAddr;
	private String userRole;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Integer userId, String userEmail, String userPassword, String userFName, String userLName,
			String userGender, LocalDate userDOB, List<String> userCC, String userCountry, String userAddr,
			String userRole) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userFName = userFName;
		this.userLName = userLName;
		this.userGender = userGender;
		this.userDOB = userDOB;
		this.userCC = userCC;
		this.userCountry = userCountry;
		this.userAddr = userAddr;
		this.userRole = userRole;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserFName() {
		return userFName;
	}

	public void setUserFName(String userFName) {
		this.userFName = userFName;
	}

	public String getUserLName() {
		return userLName;
	}

	public void setUserLName(String userLName) {
		this.userLName = userLName;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public LocalDate getUserDOB() {
		return userDOB;
	}

	public void setUserDOB(LocalDate userDOB) {
		this.userDOB = userDOB;
	}

	public List<String> getUserCC() {
		return userCC;
	}

	public void setUserCC(List<String> userCC) {
		this.userCC = userCC;
	}

	public String getUserCountry() {
		return userCountry;
	}

	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userEmail=" + userEmail + ", userPassword=" + userPassword + ", userFName="
				+ userFName + ", userLName=" + userLName + ", userGender=" + userGender + ", userDOB=" + userDOB
				+ ", userCC=" + userCC + ", userCountry=" + userCountry + ", userAddr=" + userAddr + ", userRole="
				+ userRole + "]";
	}

	
}
