 package com.kiseo.www;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


// @ControllerAdvice("com.kiseo.www") �� ��� �ش� ��Ű������ �����
@ControllerAdvice("com.kiseo2.www") // �� ��� ��� ��Ű���� ����
public class GlobalCatcher {
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model m) {
		m.addAttribute("ex",ex);
		return "error";
	}
}
