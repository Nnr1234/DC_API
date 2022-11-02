package com.ait.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.DcEducationEntity;

public interface DcEducationRepository extends JpaRepository<DcEducationEntity,Serializable>{

	public DcEducationEntity findByCaseNumber(Long caseNumber);
}
