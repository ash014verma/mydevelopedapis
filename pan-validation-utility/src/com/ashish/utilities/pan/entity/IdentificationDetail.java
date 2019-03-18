package com.ashish.utilities.pan.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the IDENTIFICATION_DETAILS database table.
 * 
 */
@Entity
@Table(name="IDENTIFICATION_DETAILS")
@NamedQuery(name="IdentificationDetail.findAll", query="SELECT i FROM IdentificationDetail i")
public class IdentificationDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ASSOC_LOAN_APP_ID", nullable=false, precision=10)
	private BigDecimal assocLoanAppId;

	@Column(name="CUSTOMER_FIRST_NAME", length=20)
	private String customerFirstName;

	@Column(name="CUSTOMER_LAST_NAME", length=20)
	private String customerLastName;

	@Column(name="CUSTOMER_MIDDLE_NAME", length=20)
	private String customerMiddleName;
	@Id
	@Column(name="IDENTIFICATION_NUMBER", nullable=false, length=50)
	private String identificationNumber;

	@Column(name="IDENTIFICATION_TYPE", length=50)
	private String identificationType;

	public IdentificationDetail() {
	}

	public BigDecimal getAssocLoanAppId() {
		return this.assocLoanAppId;
	}

	public void setAssocLoanAppId(BigDecimal assocLoanAppId) {
		this.assocLoanAppId = assocLoanAppId;
	}

	public String getCustomerFirstName() {
		return this.customerFirstName;
	}

	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	public String getCustomerLastName() {
		return this.customerLastName;
	}

	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	public String getCustomerMiddleName() {
		return this.customerMiddleName;
	}

	public void setCustomerMiddleName(String customerMiddleName) {
		this.customerMiddleName = customerMiddleName;
	}

	public String getIdentificationNumber() {
		return this.identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getIdentificationType() {
		return this.identificationType;
	}

	public void setIdentificationType(String identificationType) {
		this.identificationType = identificationType;
	}

	@Override
	public String toString() {
		return "IdentificationDetail [assocLoanAppId=" + assocLoanAppId + ", customerFirstName=" + customerFirstName
				+ ", customerLastName=" + customerLastName + ", customerMiddleName=" + customerMiddleName
				+ ", identificationNumber=" + identificationNumber + ", identificationType=" + identificationType + "]";
	}
	

}