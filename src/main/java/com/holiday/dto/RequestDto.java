package com.holiday.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String createdDatetime;
	private String editedDatetime;
	
	private String holidayRef;
	
	private String holidayName;
	
	private String holidayColor;
	
	private int holidayCapacity;
	

}
