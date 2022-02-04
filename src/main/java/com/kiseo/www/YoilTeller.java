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
//		1. �Է�
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
//		2. �۾�
		int y = Integer.parseInt(year);
		int m = Integer.parseInt(month);
		int d = Integer.parseInt(day);
		
		Calendar cal = Calendar.getInstance();
		cal.set(y, m-1, d);
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		char yoil = " �Ͽ�ȭ�������".charAt(dayOfWeek);
		
		//3. ���
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//response ��ü�κ��� ������ ��� ��Ʈ���� ��´�.
		out.println(year+"��"+ month+"��"+ day+"����");
		out.println(yoil+"�����Դϴ�");
	}

}
