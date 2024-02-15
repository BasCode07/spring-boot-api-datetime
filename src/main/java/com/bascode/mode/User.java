package com.bascode.mode;

import java.io.Serializable;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="date")
public class User{
	@Id
	@GeneratedValue
	private int id;
	private String fullName;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt = LocalDateTime.now();
	
	
	
	
	
	
	
	
	

}
