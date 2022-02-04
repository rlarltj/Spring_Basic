package com.kiseo.www;

import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTeller {
	@RequestMapping("/getYoil")
	public static void main(HttpServletRequest request, HttpServletResponse response)  throws Exception{
//		1. 입력
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
//		2. 작업
		int y = Integer.parseInt(year);
		int m = Integer.parseInt(month);
		int d = Integer.parseInt(day);
		
		Calendar cal = Calendar.getInstance();
		cal.set(y, m-1, d);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		char yoil = " 일월화수목금토".charAt(dayOfWeek);
		
		//3. 출력
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//response 객체로부터 브라우저 출력 스트림을 얻는다.
		out.println(year+"년"+ month+"월"+ day+"일은");
		out.println(yoil+"요일입니다");
	}

}
