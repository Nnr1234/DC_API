package com.ait.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.CitizenAppEntity;


	
	public interface CitizenAppRepository extends JpaRepository<CitizenAppEntity,Serializable>{
}
