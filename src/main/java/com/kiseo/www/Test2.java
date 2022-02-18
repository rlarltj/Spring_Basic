package com.kiseo.www;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

public class Test2 {

	public static void main(String[] args) throws Exception{
//		클래스 정보를 얻어온다
		Class test1 = Class.forName("com.kiseo.www.Test1");
//		얻어온 정보를 바탕으로 객체 생성
		Test1 test1Class = (Test1)test1.newInstance();
//		해당 객체에 선언된 메서드 정보를 가져온다
		Method m = test1.getDeclaredMethod("test1");
		m.setAccessible(true);
//		메서드의 접근 제어가자 private이어도 접근이 가능하게끔 한다.
		m.invoke(test1);
//		해당 메서드를 실행한다.
	}
}
