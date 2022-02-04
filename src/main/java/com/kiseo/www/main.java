package com.kiseo.www;

import java.lang.reflect.Method;

public class main {
	public static void main(String args[]) throws Exception{
		hello h = new hello();
		// h.hello();   접근제어자가 private이므로 접근 불가능
		
//		Reflection API를 사용하면 접근 가능 - 클래스 정보를 얻고 다룰 수 있는 강력한 기능 제공
//		java.lang.reflect 패키지를 제공
		
//		hello 클래스의 Class객체(클래스의 정보를 담은 객체)를 얻어온다.
		Class helloClass = Class.forName("com.kiseo.www.hello");
		hello hello  = (hello)helloClass.newInstance();
//		반환 타입이 object이므로 형변환을 해주도록 한다. class 객체가 가진 정보로 객체를 생성한다.
		
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true);  //private인 main을 호출 가능케한다.
		
		main.invoke(hello);  // hello.main()과 같다.
		
		//spring framework는 자바의 reflection API를 이용해 객체를 만들기 때문에 접근이 가능하다.
	}
}
