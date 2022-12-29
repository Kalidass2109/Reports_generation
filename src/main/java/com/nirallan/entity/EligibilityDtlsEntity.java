package com.nirallan.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="ELIGIBILITY_DTLS")
@Data
public class EligibilityDtlsEntity {
	
	@Id
	@GeneratedValue
	@Column(name="ELIG_ID")
	private Integer eligId;
	
	@Column(name="HOLDER_EMAIL")
	private String email;
	
	@Column(name="PLAN_NAME")
	private String planName;
	
	@Column(name="PLAN_STATUS")
	private String planStatus;
	
	@Column(name="START_DATE")
	private LocalDate startDate;
	
	@Column(name="END_DATE")
	private LocalDate endDate;
	
	@Column(name="CASE_NUM")
	private Long caseNum;
	
	@Column(name="BENFIT_AMT")
	private Double benfitAmt;
	
	@Column(name="DENIAL_REASON")
	private String denialreason;
	
	@Column(name="HOLDER_NAME")
	private String holderName;
	
	@Column(name="HOLDER_SSN")
	private Long holderSsn;
}
