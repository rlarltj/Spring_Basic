package com.kiseo.www;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.StringJoiner;

public class MethodInfo {
	public static void main(String[] args) throws Exception{

		//1. YoilTeller 클래스의 객체를 생성
		Class clazz = Class.forName("com.kiseo.www.YoilTeller");
		Object obj = clazz.newInstance();

		//2. 모든 메서드를 가져온 뒤 배열에 저장
		Method[] methodArr = clazz.getDeclaredMethods();
		
		//3. 메서드의 이름과 매개변수 목록, 반환타입을 출력	
		for(Method m : methodArr) {
			String name = m.getName();
			Parameter[] paramArr = m.getParameters();
//			Class[] paramTypeArr = m.getParameterTypes();
			Class returnType = m.getReturnType();
			
			StringJoiner paramList = new StringJoiner(", ", "(", ")");
			
			for(Parameter param : paramArr) {
				String paramName = param.getName();
				Class  paramType = param.getType();
				
				paramList.add(paramType.getName() + " " + paramName);
			}
			
			System.out.printf("%s %s%s%n", returnType.getName(), name, paramList);
		}
	} // main
}
