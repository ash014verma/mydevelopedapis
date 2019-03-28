package com.ashish.utilities.pan.vo;

import java.io.Serializable;

public class PANDetailsVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String identificationNumber;
	private String customerFirstName;
	private String customerMiddleName;
	private String customerLastName;
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	public String getCustomerFirstName() {
		return customerFirstName;
	}
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}
	public String getCustomerMiddleName() {
		return customerMiddleName;
	}
	public void setCustomerMiddleName(String customerMiddleName) {
		this.customerMiddleName = customerMiddleName;
	}
	public String getCustomerLastName() {
		return customerLastName;
	}
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
	@Override
	public String toString() {
		return "PANDetailsVO [identificationNumber=" + identificationNumber + ", customerFirstName=" + customerFirstName
				+ ", customerMiddleName=" + customerMiddleName + ", customerLastName=" + customerLastName + "]";
	}
	

}
