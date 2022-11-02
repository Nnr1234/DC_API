package com.ait.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="PLAN")
public class PlanEntity {

	@Id
	@GeneratedValue
	private Integer planId;
	private String planName;
}
