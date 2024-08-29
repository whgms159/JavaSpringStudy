package com.kosta.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="member_tbl")
@NoArgsConstructor
@Data
public class Member {
	
	@Id//기본 키
	@GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
	private int id;
	
	@Column(nullable=false) //name 컬럼 : not null
	private String name;
	
	@Builder
	public Member(int id, String name) {
		this.id = id;
		this.name = name;
		
	}
	
	
}
