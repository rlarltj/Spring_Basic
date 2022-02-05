package com.kiseo.www;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

public class MethodCall2 {
	public static void main(String[] args) throws Exception{

//		1. YoilTellerMVC�� ��ü�� ����
		Class clazz = Class.forName("com.kiseo.www.YoilTellerMVC");
		Object obj = clazz.newInstance();
//		2. main �޼����� ������ �����´�. main �޼��嵵 �����ε� �Ǿ��� �� �����Ƿ�, �ڿ� int.class �� �Ű����� Ÿ���� �����ش�
		Method main = clazz.getDeclaredMethod("main", int.class, int.class, int.class, Model.class);
//		3. �� ����. ���� �������̽��� ��ü ������ �Ұ����ϴ�. BindingAwareModelMap�� ���� �����Ͽ���. 
		Model model = new BindingAwareModelMap();
		System.out.println("[before] model="+model);
		
//		4. main �޼��带 ȣ��. reflection API������ invoke�� �޼��带 ȣ���ؾ� �Ѵ�.
		// String viewName = obj.main(2021, 10, 1, model);
		String viewName = (String)main.invoke(obj, new Object[] { 2021, 10, 1, model }); 	
		System.out.println("viewName="+viewName);	
		
		// Model�� ������ ��� 
		System.out.println("[after] model="+model);
				
		// �ؽ�Ʈ ������ �̿��� rendering
		render(model, viewName);			
	} // main
	
	static void render(Model model, String viewName) throws IOException {
		String result = "";
		
		// 1. ���� ������ ���پ� �о �ϳ��� ���ڿ��� �����.
		Scanner sc = new Scanner(new File("src/main/webapp/WEB-INF/views/"+viewName+".jsp"), "utf-8");
		
		while(sc.hasNextLine())
			result += sc.nextLine()+ System.lineSeparator();
		
		// 2. model�� map���� ��ȯ 
		Map map = model.asMap();
		
		// 3.key�� �ϳ��� �о template�� ${key}�� value�ٲ۴�.
		Iterator it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String key = (String)it.next();

			// 4. replace()�� key�� value ġȯ�Ѵ�.
			result = result.replace("${"+key+"}", ""+map.get(key));
		}
		
		// 5.������ ����� ����Ѵ�.
		System.out.println(result);
	}
}
