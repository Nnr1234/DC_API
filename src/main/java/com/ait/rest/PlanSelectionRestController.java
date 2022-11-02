package com.ait.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ait.binding.PlanSelection;
import com.ait.service.DcService;

@RestController
public class PlanSelectionRestController {

	@Autowired
	private DcService service;
	
	@PostMapping("/planSel")
	private ResponseEntity<Long> planSelection(@RequestBody PlanSelection planSel){
	
		Long caseNumber=service.savePlanSelection(planSel);
		
	
		return new ResponseEntity<>(caseNumber,HttpStatus.CREATED);
	}
}
