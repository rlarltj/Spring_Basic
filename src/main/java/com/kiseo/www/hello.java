package com.kiseo.www;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. 원격 호출 가능한 프로그램으로 등록. Annotation!
@Controller
public class hello {
	//2. url과 메서드를 연결
	@RequestMapping("/hello")
	private void main3() {
		System.out.println("hello-private");
	}
}
