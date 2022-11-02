package com.ait.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="DC_EDUCATION")
public class DcEducationEntity {

	@Id
	@GeneratedValue
	private Integer eduId;	
	private Long caseNumber;						
	private String highestQualification;	
	private Integer graduationYear;	

}
