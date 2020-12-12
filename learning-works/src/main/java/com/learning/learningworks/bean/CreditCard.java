package com.learning.learningworks.bean;

import org.springframework.data.annotation.Id;

public class CreditCard {
	
	@Id
	private String ccNumber;
	private String ccExpDate;
	private String ccCVV;

	public CreditCard() {
		// TODO Auto-generated constructor stub
	}

	public CreditCard(String ccNumber, String ccExpDate, String ccCVV) {
		super();
		this.ccNumber = ccNumber;
		this.ccExpDate = ccExpDate;
		this.ccCVV = ccCVV;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public String getCcExpDate() {
		return ccExpDate;
	}

	public void setCcExpDate(String ccExpDate) {
		this.ccExpDate = ccExpDate;
	}

	public String getCcCVV() {
		return ccCVV;
	}

	public void setCcCVV(String ccCVV) {
		this.ccCVV = ccCVV;
	}

	@Override
	public String toString() {
		return "CreditCard [ccNumber=" + ccNumber + ", ccExpDate=" + ccExpDate + ", ccCVV=" + ccCVV + "]";
	}

}
