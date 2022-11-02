package com.ait.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ait.entity.PlanEntity;

public  interface PlanRepository extends JpaRepository<PlanEntity,Serializable> {

}
