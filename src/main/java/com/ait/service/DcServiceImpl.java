package com.ait.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ait.binding.Child;
import com.ait.binding.ChildRequest;
import com.ait.binding.DcSummary;
import com.ait.binding.Education;
import com.ait.binding.Income;
import com.ait.binding.PlanSelection;
import com.ait.entity.CitizenAppEntity;
import com.ait.entity.DcCaseEntity;
import com.ait.entity.DcChildrenEntity;
import com.ait.entity.DcEducationEntity;
import com.ait.entity.DcIncomeEntity;
import com.ait.entity.PlanEntity;
import com.ait.repository.CitizenAppRepository;
import com.ait.repository.DcCaseRepo;
import com.ait.repository.DcChildrenRepository;
import com.ait.repository.DcEducationRepository;
import com.ait.repository.DcIncomeRepository;
import com.ait.repository.PlanRepository;


@Service
public class DcServiceImpl implements DcService {



	@Autowired
	private CitizenAppRepository appRepo;
	
	@Autowired
	private DcCaseRepo dcCaseRepo;
	
	@Autowired
	private DcChildrenRepository childRepo;
	
	@Autowired
	private DcEducationRepository educationRepo;
	
	@Autowired
	private DcIncomeRepository incomeRepo;
	
	@Autowired
	private PlanRepository planRepo;
	
	
	@Override
	public Long loadCaseNumber(Integer appId) {
		Optional<CitizenAppEntity> app = appRepo.findById(appId);
		
		if(app.isPresent()) {
			
		DcCaseEntity entity= new DcCaseEntity();
		entity.setAppId(appId);
		
		entity = dcCaseRepo.save(entity);
    
		return entity.getCaseNumber();
	}
		return 01L;
	}
	
	@Override
	public Map<Integer,String> getPlanNames() {
		
		List<PlanEntity> findAll = planRepo.findAll();
		
		Map<Integer,String> plansMap=new HashMap<>();
		
		for(PlanEntity entity:findAll) {
			plansMap.put(entity.getPlanId(),entity.getPlanName());
		}
		return plansMap;
	}

	@Override
	public Long savePlanSelection(PlanSelection planSelection) {
     Optional<DcCaseEntity> findById=dcCaseRepo.findById(planSelection.getCaseNum());
		
		if(findById.isPresent()) {
			DcCaseEntity dcCaseEntity = findById.get();
			dcCaseEntity.setPlanId(planSelection.getPlanId());
			dcCaseRepo.save(dcCaseEntity);
			
			return planSelection.getCaseNum();
		}
		return null;
	}
	

	@Override
	public Long saveIncomeDetails(Income income) {
		
         DcIncomeEntity entity=new DcIncomeEntity();
         BeanUtils.copyProperties(income, entity);
         
         incomeRepo.save(entity);
         
		return income.getCaseNum();
	}

	@Override
	public Long saveEducationDeatils(Education education) {
     DcEducationEntity entity=new DcEducationEntity();
     BeanUtils.copyProperties(education, entity);
     
     educationRepo.save(entity);
		return education.getCaseNum();
	}

	@Override
	public Long saveChildren(ChildRequest request) {
     
		List<Child> childs = request.getChilds();
		
		for(Child c :childs) {
			DcChildrenEntity entity=new DcChildrenEntity();
			BeanUtils.copyProperties(c, entity);
			
			childRepo.save(entity);
		}
		//childRepo.saveAll(entities);
		return request.getCaseNumber();
	}

	@Override
	public DcSummary getSummary(Long caseNumber) {
		
		String planName="";
		
    DcIncomeEntity incomeEntity = incomeRepo.findByCaseNumber(caseNumber);
    DcEducationEntity educationEntity = educationRepo.findByCaseNumber(caseNumber);
    List<DcChildrenEntity> childrenEntity = childRepo.findByCaseNumber(caseNumber);
   
    Optional<DcCaseEntity> dcCase = dcCaseRepo.findById(caseNumber);
   if(dcCase.isPresent()) {
	   Integer planId = dcCase.get().getPlanId();
	   Optional<PlanEntity> plan = planRepo.findById(planId);
	   if(plan.isPresent()) {
		    planName= plan.get().getPlanName();
	   }
   }
   
   
   DcSummary summary  =new DcSummary();
   summary.setPlanName(planName);
   
   Income income=new Income();
   BeanUtils.copyProperties(incomeEntity, income);
   summary.setIncome(income);
   
   Education edu=new Education();
   BeanUtils.copyProperties(educationEntity, edu);
   summary.setEducation(edu);
   
   List<Child>childs=new ArrayList<>();  
   for(DcChildrenEntity entity:childrenEntity ) {
	   Child ch=new Child();
	   BeanUtils.copyProperties(entity, ch);
	   childs.add(ch);
   }
   summary.setChilds(childs);
		return summary;
	}

}
