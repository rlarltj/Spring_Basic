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
//			id와 pwd가 일치하지 않으면, loginForm으로 이동
			String msg = URLEncoder.encode("id 또는 패스워드가 일치하지 않습니다.", "utf-8");
			return "redirect:/login/login?msg="+msg;
		}
//		id와 pwd가 일치하면, 세션 객체에 id를 저장
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		if(rememberId) {
//			1. 쿠키를 생성하고
			Cookie cookie = new Cookie("id", id);
			
//			2. 응답에 저장 
			response.addCookie(cookie);
			
		}else {
//			1. 쿠키를 생성하고
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0);
//			2. 응답에 저장 
			response.addCookie(cookie);
		}
//		id와 pwd가 일치하면 
//		3. 홈으로 이동
		toUrl = (toUrl == null || toUrl.equals("")) ? "/" : toUrl;
		
		return "redirect:"+toUrl;	
	}
	

	private boolean loginCheck(String id, String pwd) {
		
		return "asdf".equals(id) && "1234".equals(pwd);
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
//		1. 로그아웃 시 세션을 종료한다.
//		2. 홈으로 이동
		session.invalidate();
		return "redirect:/";
	}
	
	
}
