package com.board.common;



import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice // 예외처리 클래스 명시
public class ExceptionHandlers {
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) {
		log.error("예외 발생 : {}", e.getMessage());
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorMsg", e.getMessage());
		return mv;

	}	
}
