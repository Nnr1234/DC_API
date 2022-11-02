package com.ait.binding;


import java.util.Map;

import lombok.Data;

@Data
public class CreateCaseResponse {

	
	private Long caseNumber;
	private Map<Integer,String> planNames;
}
