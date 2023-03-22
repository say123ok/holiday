package com.holiday.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.holiday.entity.Tholiday;

@Repository
public interface HolidayRepo extends JpaRepository<Tholiday, Long>, PagingAndSortingRepository<Tholiday, Long> {
	@Modifying
		
	@Query("update Tholiday tHoliday set tHoliday.holidayRef = :holidayRef, " +
		       "tHoliday.holidayName = :holidayName, tHoliday.holidayColor = :holidayColor, " +
			   "tHoliday.holidayCapacity = :holidayCapacity, tHoliday.createdDatetime = :createdDatetime "
			   + ", tHoliday.editedDatetime = :editedDatetime , tHoliday.version= tHoliday.version+1 where tHoliday.id = :id")
int updateHoliday(@Param("holidayRef") String holidayRef, @Param("holidayName") String holidayName, 
				@Param("holidayColor") String holidayColor, @Param("holidayCapacity") int holidayCapacity, 
				@Param("createdDatetime") LocalDateTime createdDatetime, @Param("editedDatetime") LocalDateTime editedDatetime,
				@Param("id") long id);

}
