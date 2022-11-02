package com.ait.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.DcChildrenEntity;

public interface DcChildrenRepository extends JpaRepository<DcChildrenEntity,Serializable>{
	public List<DcChildrenEntity> findByCaseNumber(Long caseNumber);
	
	
	
}
