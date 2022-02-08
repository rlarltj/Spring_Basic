package com.kiseo.www;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
	@GetMapping("/login")
	public String loginForm() {
		
		return "loginForm";	
	}
	
	@PostMapping("/login")
	public String loginForm(String id, String pwd, String toUrl, boolean rememberId, HttpServletRequest request ,HttpServletResponse response) throws Exception{
		if(!loginCheck(id, pwd)) {
//			id�� pwd�� ��ġ���� ������, loginForm���� �̵�
			String msg = URLEncoder.encode("id �Ǵ� �н����尡 ��ġ���� �ʽ��ϴ�.", "utf-8");
			return "redirect:/login/login?msg="+msg;
		}
//		id�� pwd�� ��ġ�ϸ�, ���� ��ü�� id�� ����
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		if(rememberId) {
//			1. ��Ű�� �����ϰ�
			Cookie cookie = new Cookie("id", id);
			
//			2. ���信 ���� 
			response.addCookie(cookie);
			
		}else {
//			1. ��Ű�� �����ϰ�
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0);
//			2. ���信 ���� 
			response.addCookie(cookie);
		}
//		id�� pwd�� ��ġ�ϸ� 
//		3. Ȩ���� �̵�
		toUrl = (toUrl == null || toUrl.equals("")) ? "/" : toUrl;
		
		return "redirect:"+toUrl;	
	}
	

	private boolean loginCheck(String id, String pwd) {
		
		return "asdf".equals(id) && "1234".equals(pwd);
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
//		1. �α׾ƿ� �� ������ �����Ѵ�.
//		2. Ȩ���� �̵�
		session.invalidate();
		return "redirect:/";
	}
	
	
}
