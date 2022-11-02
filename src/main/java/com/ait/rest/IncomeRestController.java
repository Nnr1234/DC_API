package com.ait.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ait.binding.Income;
import com.ait.service.DcService;

@RestController
public class IncomeRestController {

    @Autowired
	private DcService service;
    
    @PostMapping("/income")
    private ResponseEntity<Long>saveIncome(@RequestBody Income income){
    
   Long caseNumber= service.saveIncomeDetails(income);
    
   return new ResponseEntity<>(caseNumber,HttpStatus.CREATED);
    }
    
}
