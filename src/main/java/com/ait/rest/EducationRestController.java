package com.ait.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ait.binding.Education;
import com.ait.service.DcService;

@RestController
public class EducationRestController {

   @Autowired	
	private DcService service;
   
   @PostMapping("/education")
   private ResponseEntity<Long> saveEducation(@RequestBody Education education){
    Long caseNumber = service.saveEducationDeatils(education);
  
   return new ResponseEntity<>(caseNumber,HttpStatus.CREATED);
   }
}