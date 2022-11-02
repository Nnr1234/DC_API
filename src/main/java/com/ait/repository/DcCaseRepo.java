package com.ait.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.DcCaseEntity;

public interface DcCaseRepo extends JpaRepository<DcCaseEntity,Serializable>{
	
	public DcCaseEntity findByAppId(Integer appId);
	//public DcCaseEntity findByIdCaseNumber(Long caseNumber);
}
