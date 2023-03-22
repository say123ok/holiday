package com.holiday.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;


@Data
@Table(name = "t_holiday")
@Entity
public class Tholiday {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(
			name = "holidayUID",
			strategy = "increment" 
			)
	@Column(nullable = false, length = 32)
	  private long id;
	
	 @Version
	    @Column(
	        nullable = false
	    )
	    private Integer version;
	    @CreatedDate
	    @Column(
	        nullable = false
	    )
	    private LocalDateTime createdDatetime;
	    @LastModifiedDate
	    @Column(
	        nullable = false
	    )
	    private LocalDateTime editedDatetime;
	    
	    @Column(length = 50)
	    private String holidayRef;
	    
	    @Column(length = 255)
	    private String holidayName;
	    
	    @Column(length = 50)
	    private String holidayColor;
	    
	    @Column
	    private int holidayCapacity;
	    
	

}
