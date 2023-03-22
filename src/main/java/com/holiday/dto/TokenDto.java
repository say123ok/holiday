package com.holiday.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TokenDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("data")
	private List<DataToken> data;
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("status")
	private Integer status;
	
	

}
