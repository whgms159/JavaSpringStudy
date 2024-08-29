package com.kosta.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="stu_tbl")
@NoArgsConstructor
@Data

public class Stu {
	@Id//기본 키
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
	private int id;
	
	@Column(nullable = false)
	private String name;

	@Builder
	public Stu(int id, String name) {
		this.id = id;
		this.name = name;
	}

}
