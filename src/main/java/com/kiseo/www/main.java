package com.kiseo.www;

import java.lang.reflect.Method;

public class main {
	public static void main(String args[]) throws Exception{
		hello h = new hello();
		// h.hello();   ���������ڰ� private�̹Ƿ� ���� �Ұ���
		
//		Reflection API�� ����ϸ� ���� ���� - Ŭ���� ������ ��� �ٷ� �� �ִ� ������ ��� ����
//		java.lang.reflect ��Ű���� ����
		
//		hello Ŭ������ Class��ü(Ŭ������ ������ ���� ��ü)�� ���´�.
		Class helloClass = Class.forName("com.kiseo.www.hello");
		hello hello  = (hello)helloClass.newInstance();
//		��ȯ Ÿ���� object�̹Ƿ� ����ȯ�� ���ֵ��� �Ѵ�. class ��ü�� ���� ������ ��ü�� �����Ѵ�.
		
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true);  //private�� main�� ȣ�� �������Ѵ�.
		
		main.invoke(hello);  // hello.main()�� ����.
		
		//spring framework�� �ڹ��� reflection API�� �̿��� ��ü�� ����� ������ ������ �����ϴ�.
	}
}
