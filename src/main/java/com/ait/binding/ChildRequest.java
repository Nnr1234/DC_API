package com.ait.binding;

import java.util.List;

import lombok.Data;


@Data
public class ChildRequest {

	private Long caseNumber;
	
	private List<Child>childs;
}
