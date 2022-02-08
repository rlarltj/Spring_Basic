package com.kiseo.www;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller  //1. 원격으로 호출 가능한 프로그램 등록
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//2. url과 메서드를 연결(매핑)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		
		return "index";
	}
	
}
