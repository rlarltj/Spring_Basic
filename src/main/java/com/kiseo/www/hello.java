package com.kiseo.www;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. ���� ȣ�� ������ ���α׷����� ���. Annotation!
@Controller
public class hello {
	//2. url�� �޼��带 ����
	@RequestMapping("/hello")
	private void main3() {
		System.out.println("hello-private");
	}
}
