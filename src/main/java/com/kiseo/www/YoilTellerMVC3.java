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
	//��ó�� key ���� ������ ��� Ÿ��(MyDate)�� ù ���ڸ� �ҹ��ڷ� �� ���� key�� �ڵ� ����ȴ�.
		System.out.println("result="+result);
//		1. ��ȿ�� �˻�
		if(!isValid(date)) return "yoilError";
		
//		2. ���� ���
//		char yoil = getYoil(date);

//		3. ����� ����� Model�� ����
		
//		model.addAttribute("myDate", date);

//		model.addAttribute("yoil", yoil);
		
//		4. �۾� ����� ������ View�� �̸��� ��ȯ
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

	private static boolean isValid(MyDate date) {
		
		return true;
	}

	private static @ModelAttribute("yoil") char getYoil(MyDate date) {
		Calendar cal = Calendar.getInstance();
		cal.set(date.getYear(), date.getMonth()-1, date.getDay());
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return " �Ͽ�ȭ�������".charAt(dayOfWeek);
	}

}
