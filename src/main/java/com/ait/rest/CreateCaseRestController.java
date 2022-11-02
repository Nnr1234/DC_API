package com.ait.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ait.binding.CreateCaseResponse;
import com.ait.service.DcService;


@RestController
public class CreateCaseRestController {

	@Autowired
	private DcService service;
	
	@GetMapping("/case/{appId}")
	private ResponseEntity<CreateCaseResponse>createCase(@PathVariable Integer appId){
	
	Long caseNumber = service.loadCaseNumber(appId);
	
	Map<Integer,String> planNames = service.getPlanNames();
	
	CreateCaseResponse response =new CreateCaseResponse();
	response.setCaseNumber(caseNumber);
	response.setPlanNames(planNames);
	
	return new ResponseEntity<>(response,HttpStatus.OK);
}
	
}