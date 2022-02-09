package com.kiseo.www;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
	
//	try-catch�� �ߺ��� ���� ��ó�� ����ó���� ���ִ� �Լ��� ������ ������. ��� ������̼��� �ʿ��ϴ�.
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
	
//	���� ó�� ���ִ� �Լ��� ������ ���� �� �ִ�. �߻��� ������ ��ġ�ϴ� catcher�� ���� ���, ���� exception�� ó���Ѵ�. 
//	Ȥ�� �Ű������� �迭�� �����ص� �� ({NullPointerException.class, FileNotFound.class}) ��
//	���ܸ� ó���ϴ� �޼���� �� ��Ʈ�ѷ� �������� �۵��Ѵ�. �ٸ� ��Ʈ�ѷ����� ���ܰ� �߻��ϸ�, �� ��Ʈ�ѷ��� ���� catcher �޼��尡 �ʿ��ϴ�.
//	������ ���� ó���ϴ� �޼��带 �� ���� ��Ƽ� ��� ��Ʈ�ѷ��� �ѷ��� �� �ִ�. @ControllerAdvice ������̼��� �װ��̴�. GlobalCatcher.java ����
	@ExceptionHandler(NullPointerException.class)
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
	
	@RequestMapping("/ex")
	public String main(Model model) throws Exception{
			throw new Exception("���ܰ� �߻��߽��ϴ�.");
	}
	
	@RequestMapping("/ex2")
	public String main2(Model model) throws NullPointerException{
			throw new NullPointerException("���ܰ� �߻��߽��ϴ�.");
	}

}
