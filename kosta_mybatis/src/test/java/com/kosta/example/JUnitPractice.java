package com.kosta.example;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitPractice {
	@DisplayName("문제1")
	@Test
	public void practice1() {
		String name1="이제훈";
		String name2="이제훈";
		String name3="이재훈";
		
		
		assertThat(name1).isNotNull();
		assertThat(name2).isNotNull();
		assertThat(name3).isNotNull();
		
		
		assertThat(name1).isEqualTo(name2);
		assertThat(name1).isNotEqualTo(name3);
		
	}
	@DisplayName("문제2")
	@Test
	public void practice2() {
		int num1=15;
		int num2=0;
		int num3=-5;
		
		assertThat(num1).isPositive();
		assertThat(num2).isZero();
		assertThat(num3).isNegative();
		assertThat(num1).isGreaterThan(num2);
		assertThat(num3).isLessThan(num2);
		
	}
}
