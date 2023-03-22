package com.holiday.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.holiday.dto.RequestDto;
import com.holiday.entity.Tholiday;
import com.holiday.service.HolidayService;



@RestController
@RequestMapping("/v1")
public class HolidayController {
	
	@Autowired private HolidayService holidayService;
	
	private final Logger log = LoggerFactory.getLogger(HolidayController.class);
		
	@GetMapping("/getHolidays")
	public ResponseEntity<Page<Tholiday>> getHolidays(
			@PageableDefault(size = 10) 
			Pageable pageable

			) {
		log.info("getHolidays method");
				
//		Page<Tholiday> res = holidayService.getHolidays(pageNo, pageSize);
		Page<Tholiday> res = holidayService.getHolidays(pageable);
		log.info("getHolidays method res {}", res);
		return ResponseEntity.ok().body(res);
	}
	
	@PostMapping("/addHoliday")
	public ResponseEntity<Tholiday> addHoliday(
			@RequestBody RequestDto tholiday) {
		
		log.info("addHoliday request {}" , tholiday);
		Tholiday resp = holidayService.saveAndFlush(tholiday) ;
		
		log.info("addHoliday method resp {}", resp);
		return ResponseEntity.ok().body(resp);
	}
	
		
	@PostMapping("/modHoliday")
	public ResponseEntity<String> modHoliday(
			@RequestBody RequestDto tholiday) {
		
		log.info("modHoliday method request {}" , tholiday);
		int resp = holidayService.updHoliday(tholiday);
		
		String modRes = resp == 1 ? "Update Success" : "Update Failed" ;
		
		log.info("modHoliday method resp {}", modRes);
		return ResponseEntity.ok().body(modRes);
	}
	
	
	@GetMapping("/callWS")	
	public ResponseEntity<String> callWS() {
		log.info("callWS method");
		
		String res = holidayService.getToken();
		
		log.info("callWS response {}" ,res) ;
		
		return ResponseEntity.ok().body( res);
	}

}
