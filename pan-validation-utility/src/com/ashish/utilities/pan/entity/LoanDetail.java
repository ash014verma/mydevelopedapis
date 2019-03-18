package com.ashish.utilities.pan.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the LOAN_DETAILS database table.
 * 
 */
@Entity
@Table(name="LOAN_DETAILS")
@NamedQuery(name="LoanDetail.findAll", query="SELECT l FROM LoanDetail l")
public class LoanDetail implements Serializable {
	@OneToOne
	private IdentificationDetail identificationDetail;

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="LOAN_APP_ID", nullable=false, precision=10)
	private BigDecimal loanAppId;

	@Temporal(TemporalType.DATE)
	@Column(name="LOAN_DISBURSED_DATE")
	private Date loanDisbursedDate;

	@Column(name="LOAN_STATUS", length=50)
	private String loanStatus;

	public LoanDetail() {
	}

	public BigDecimal getLoanAppId() {
		return this.loanAppId;
	}

	public void setLoanAppId(BigDecimal loanAppId) {
		this.loanAppId = loanAppId;
	}

	public Date getLoanDisbursedDate() {
		return this.loanDisbursedDate;
	}

	public void setLoanDisbursedDate(Date loanDisbursedDate) {
		this.loanDisbursedDate = loanDisbursedDate;
	}

	public String getLoanStatus() {
		return this.loanStatus;
	}

	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public IdentificationDetail getIdentificationDetail() {
		return identificationDetail;
	}

	public void setIdentificationDetail(IdentificationDetail identificationDetail) {
		this.identificationDetail = identificationDetail;
	}

	@Override
	public String toString() {
		return "LoanDetail [identificationDetail=" + identificationDetail + ", loanAppId=" + loanAppId
				+ ", loanDisbursedDate=" + loanDisbursedDate + ", loanStatus=" + loanStatus + "]";
	}

}