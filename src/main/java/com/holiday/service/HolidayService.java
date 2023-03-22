package com.holiday.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.holiday.dto.DataToken;
import com.holiday.dto.RequestDto;
import com.holiday.dto.TokenDto;
import com.holiday.entity.Tholiday;

public interface HolidayService {
	
	Tholiday saveAndFlush (RequestDto tHoliday);
	
	int updHoliday (RequestDto tHoliday);
	
//	Page<Tholiday> getHolidays (int pageNo, int pageSize);
	Page<Tholiday> getHolidays (Pageable pageable);
	
	String getToken();

}
