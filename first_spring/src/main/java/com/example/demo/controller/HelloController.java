package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController //해당 클래스가 REST CONTROLLER 기능을 수행하도록 한다
public class HelloController {
	@RequestMapping("/") //메소드가 실행할 수 있는 주소 설정
	public String hello() {
		return "안녕 스프링ㄹㄹ";
	}
	
	@RequestMapping("/hello") //메소드가 실행할 수 있는 주소 설정
	public String hello2() {
		return "안녕 스프링!!!!fe";
	}
	
}
