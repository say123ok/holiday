package com.holiday.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	
	private Integer version;
	
	private LocalDateTime createdDatetime;
	
	private LocalDateTime editedDatetime;
	
	
	private String holidayRef;
	
	private String holidayName;
	
	private String holidayColor;
	
	private int holidayCapacity;

}
