package com.ait.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ait.binding.ChildRequest;
import com.ait.binding.DcSummary;
import com.ait.service.DcService;

@RestController
public class ChildRequestController {

	@Autowired
	private DcService dcService;
	
	@PostMapping("/childrens")
	private  ResponseEntity<DcSummary> saveChilds(@RequestBody ChildRequest request){

	Long casenumber = dcService.saveChildren(request);
	DcSummary summary = dcService.getSummary(casenumber);
	return new ResponseEntity<>(summary,HttpStatus.OK);
		
	}
	}