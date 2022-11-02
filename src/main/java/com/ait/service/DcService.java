package com.ait.service;

import java.util.List;
import java.util.Map;

import com.ait.binding.Child;
import com.ait.binding.ChildRequest;
import com.ait.binding.DcSummary;
import com.ait.binding.Education;
import com.ait.binding.Income;
import com.ait.binding.PlanSelection;

public interface DcService{

	public Long loadCaseNumber(Integer appId);
	public Map<Integer,String> getPlanNames();
	public Long savePlanSelection(PlanSelection planSelection);
	public  Long saveIncomeDetails(Income income);
	public Long saveEducationDeatils(Education education);
	public Long saveChildren(ChildRequest request);
	public DcSummary getSummary(Long caseNumber);
	 
}
