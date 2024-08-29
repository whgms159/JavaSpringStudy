package com.kosta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin/**")
@RequiredArgsConstructor
public class AdminContoller {
	
	@GetMapping("")
	public String adminPage() {
		return "admin/index";
	}

}
