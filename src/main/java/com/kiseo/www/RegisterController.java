package com.kiseo.www;

import java.net.URLEncoder;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
//	@RequestMapping("/register/add")
//	@GetMapping("/register/add")
//	public String register() {
//		return "registerForm";
//	}
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save")  //������ 4.3���� �̿� ������. pom.xml�� properties���� �����ؾ���.
	public String save(User user, Model m) throws Exception {
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id�� �߸��Է��߽��ϴ�.", "utf-8");

//			m.addAttribute("msg",msg);         �Ѱ���� �� ���� ���� ���, �̷� ������� �߰��ؼ� ��������.
//			return "redirect:/register/add;  �ٵ� Model�� save���� �̿��� �����͸� ��� ���ε�, ������ redirect���� �𵨿� ��Ƽ� �����ϰ��� �Ѵ�.
//			�̴� spring�� �� �� ���� �Ʒ��� �ڵ�� �ڵ� ��ȯ���ֱ� ������ ������.
			return "redirect:/register/add?msg=" + msg;
		}
		return "registerInfo";
	}

private boolean isValid(User user) {
	
	return false;
}
}
