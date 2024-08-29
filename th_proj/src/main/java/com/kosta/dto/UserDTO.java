package com.kosta.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class UserDTO {
	private int id;
	private String name, email;
	private LocalDateTime createdAt;
	
}
