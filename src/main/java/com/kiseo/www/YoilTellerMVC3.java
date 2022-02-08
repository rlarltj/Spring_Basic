package com.kiseo.www;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTellerMVC3 {
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, BindingResult result) {
		ex.printStackTrace();
		System.out.println("result="+result);
		return "yoilError";
	}
	
	
	@RequestMapping("/getYoilMVC3")
//	public static String main(@ModelAttribute("myDate") MyDate date, Model model)  throws Exception{
	public static String main(MyDate date, BindingResult result)  throws Exception{
	//이처럼 key 값을 생략할 경우 타입(MyDate)의 첫 글자를 소문자로 한 값이 key로 자동 저장된다.
		System.out.println("result="+result);
//		1. 유효성 검사
		if(!isValid(date)) return "yoilError";
		
//		2. 요일 계산
//		char yoil = getYoil(date);

//		3. 계산한 결과를 Model에 저장
		
//		model.addAttribute("myDate", date);

//		model.addAttribute("yoil", yoil);
		
//		4. 작업 결과를 보여줄 View의 이름을 반환
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

	private static boolean isValid(MyDate date) {
		
		return true;
	}

	private static @ModelAttribute("yoil") char getYoil(MyDate date) {
		Calendar cal = Calendar.getInstance();
		cal.set(date.getYear(), date.getMonth()-1, date.getDay());
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return " 일월화수목금토".charAt(dayOfWeek);
	}

}
