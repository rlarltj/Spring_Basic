package com.kiseo.www;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

public class Test2 {

	public static void main(String[] args) throws Exception{
//		Ŭ���� ������ ���´�
		Class test1 = Class.forName("com.kiseo.www.Test1");
//		���� ������ �������� ��ü ����
		Test1 test1Class = (Test1)test1.newInstance();
//		�ش� ��ü�� ����� �޼��� ������ �����´�
		Method m = test1.getDeclaredMethod("test1");
		m.setAccessible(true);
//		�޼����� ���� ����� private�̾ ������ �����ϰԲ� �Ѵ�.
		m.invoke(test1);
//		�ش� �޼��带 �����Ѵ�.
	}
}
