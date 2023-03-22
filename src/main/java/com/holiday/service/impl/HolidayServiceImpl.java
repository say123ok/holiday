package com.holiday.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.holiday.dto.DataToken;
import com.holiday.dto.RequestDto;
import com.holiday.dto.TokenDto;
import com.holiday.entity.Tholiday;
import com.holiday.repository.HolidayRepo;
import com.holiday.service.HolidayService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
public class HolidayServiceImpl implements HolidayService {

	
	@Autowired private HolidayRepo holidayRepo;
	
	@Override
	public Tholiday saveAndFlush(RequestDto tHoliday) {
		// TODO Auto-generated method stub
		Tholiday tmp = new Tholiday();
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		LocalDateTime localCreatedDatetime = LocalDateTime.parse(tHoliday.getCreatedDatetime(),dateTimeFormatter);
		
		LocalDateTime localEditedDatetime = LocalDateTime.parse(tHoliday.getEditedDatetime(),dateTimeFormatter);
		
		
		tmp.setCreatedDatetime(localCreatedDatetime);
		tmp.setEditedDatetime(localEditedDatetime);
		tmp.setHolidayCapacity(tHoliday.getHolidayCapacity());
		tmp.setHolidayColor(tHoliday.getHolidayColor());
		tmp.setHolidayName(tHoliday.getHolidayName());
		tmp.setHolidayRef(tHoliday.getHolidayRef());
		
		
		return holidayRepo.save(tmp);
	}

	@Override
	public int updHoliday(RequestDto tHoliday) {
		// TODO Auto-generated method stub
Tholiday tmp = new Tholiday();
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		LocalDateTime localCreatedDatetime = LocalDateTime.parse(tHoliday.getCreatedDatetime(),dateTimeFormatter);
		
		LocalDateTime localEditedDatetime = LocalDateTime.parse(tHoliday.getEditedDatetime(),dateTimeFormatter);
		
		tmp.setId(tHoliday.getId());
		tmp.setCreatedDatetime(localCreatedDatetime);
		tmp.setEditedDatetime(localEditedDatetime);
		tmp.setHolidayCapacity(tHoliday.getHolidayCapacity());
		tmp.setHolidayColor(tHoliday.getHolidayColor());
		tmp.setHolidayName(tHoliday.getHolidayName());
		tmp.setHolidayRef(tHoliday.getHolidayRef());
		
		
		return holidayRepo.updateHoliday(tmp.getHolidayRef(), tmp.getHolidayName(), 
				tmp.getHolidayColor(), tmp.getHolidayCapacity(), localCreatedDatetime, localEditedDatetime, tmp.getId());
	}

	@Override
	public Page<Tholiday> getHolidays(Pageable pageable) {
		
//		long count = holidayRepo.count();
//		
//		Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
//
//		Pageable secondPageWithFiveElements = PageRequest.of(1, 5);
		
//		return holidayRepo.findAll(firstPageWithTwoElements);
		return holidayRepo.findAll(pageable);
	}

	@Override
	public String getToken() {
		
		final String  url = "http://localhost:5000/signin";
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<TokenDto> response = restTemplate.getForEntity(url, TokenDto.class) ;
		
		String token = response.getBody().getData().get(0).getToken();
				
		return token;
		

	}
	

}
