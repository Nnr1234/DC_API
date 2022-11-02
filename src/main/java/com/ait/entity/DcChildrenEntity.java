package com.ait.entity;



import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="DC_CHILDRENS")
public class DcChildrenEntity {

@Id	
private Integer	childrenId;
	private Long caseNumber;		
	private LocalDate childrenDob;
	private Long childrenSsn;	
}
