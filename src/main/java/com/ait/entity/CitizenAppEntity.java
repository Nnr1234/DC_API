package com.ait.entity;



import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;



@Entity
@Data
@Table(name="CITIZEN_APP")
public class CitizenAppEntity {

	@Id
	@GeneratedValue
	private Integer childrenId;	
	private Long caseNumber;
	private LocalDate dob;
	private Long ssn;

}
