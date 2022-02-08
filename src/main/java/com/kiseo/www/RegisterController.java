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
	@PostMapping("/register/save")  //스프링 4.3부터 이용 가능함. pom.xml의 properties에서 변경해야함.
	public String save(User user, Model m) throws Exception {
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못입력했습니다.", "utf-8");

//			m.addAttribute("msg",msg);         넘겨줘야 할 값이 많은 경우, 이런 방식으로 추가해서 전송하자.
//			return "redirect:/register/add;  근데 Model은 save에서 이용할 데이터를 담는 것인데, 지금은 redirect지만 모델에 담아서 전송하고자 한다.
//			이는 spring이 위 두 줄을 아래의 코드로 자동 변환해주기 때문에 괜찮다.
			return "redirect:/register/add?msg=" + msg;
		}
		return "registerInfo";
	}

private boolean isValid(User user) {
	
	return false;
}
}
