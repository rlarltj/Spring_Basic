package com.kiseo.www;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class YoilTellerMVC {
	@RequestMapping("/getYoilMVC")
	public static String main(int year, int month, int day, Model model)  throws Exception{
		
		
//		1. ��ȿ�� �˻�
		if(!isValid(year,month,day)) return "yoilError";
		
//		2. ���� ���
		char yoil = getYoil(year, month, day);

//		3. ����� ����� Model�� ����
		
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("yoil", yoil);
		
		return "yoil";
		//		
//		//3. ���
//		response.setContentType("text/html");
//		response.setCharacterEncoding("utf-8");
//		PrintWriter out = response.getWriter();
//		//response ��ü�κ��� ������ ��� ��Ʈ���� ��´�.
//		out.println(year+"��"+ month+"��"+ day+"����");
//		out.println(yoil+"�����Դϴ�");
	}

	private static boolean isValid(int year, int month, int day) {
		
		return true;
	}

	private static char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return " �Ͽ�ȭ�������".charAt(dayOfWeek);
	}

}
