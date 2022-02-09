 package com.kiseo.www;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


// @ControllerAdvice("com.kiseo.www") 이 경우 해당 패키지에만 적용됨
@ControllerAdvice("com.kiseo2.www") // 이 경우 모든 패키지에 적용
public class GlobalCatcher {
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model m) {
		m.addAttribute("ex",ex);
		return "error";
	}
}
