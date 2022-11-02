package com.ait.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CitizenApp {

	
	private Integer childrenId;	
	private Long caseNum;
	private LocalDate dob;
	private Long ssn;
}
