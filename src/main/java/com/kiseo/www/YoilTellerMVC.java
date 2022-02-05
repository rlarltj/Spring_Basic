package com.kiseo.www;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTellerMVC {
	@RequestMapping("/getYoilMVC")
	public static String main(int year, int month, int day, Model model)  throws Exception{
		
		
//		1. 유효성 검사
		if(!isValid(year,month,day)) return "yoilError";
		
//		2. 요일 계산
		char yoil = getYoil(year, month, day);

//		3. 계산한 결과를 Model에 저장
		
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
		
		return "yoil";
		//		
//		//3. 출력
//		response.setContentType("text/html");
//		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//		//response 객체로부터 브라우저 출력 스트림을 얻는다.
//		out.println(year+"년"+ month+"월"+ day+"일은");
//		out.println(yoil+"요일입니다");
	}

	private static boolean isValid(int year, int month, int day) {
		
		return true;
	}

	private static char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return " 일월화수목금토".charAt(dayOfWeek);
	}

}
