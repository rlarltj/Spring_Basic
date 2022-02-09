package com.kiseo.www;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController {
	
//	try-catch가 중복될 때는 이처럼 예외처리를 해주는 함수를 별도로 만들자. 대신 어노테이션이 필요하다.
	@ExceptionHandler(Exception.class)
	public String catcher(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
	
//	예외 처리 해주는 함수도 여러개 만들 수 있다. 발생한 에러와 일치하는 catcher가 없을 경우, 조상 exception이 처리한다. 
//	혹은 매개변수에 배열로 전달해도 됨 ({NullPointerException.class, FileNotFound.class}) 등
//	예외를 처리하는 메서드는 그 컨트롤러 내에서만 작동한다. 다른 컨트롤러에서 예외가 발생하면, 그 컨트롤러에 역시 catcher 메서드가 필요하다.
//	하지만 예외 처리하는 메서드를 한 곳에 모아서 모든 컨트롤러로 뿌려줄 수 있다. @ControllerAdvice 어노테이션이 그것이다. GlobalCatcher.java 참고
	@ExceptionHandler(NullPointerException.class)
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
	
	@RequestMapping("/ex")
	public String main(Model model) throws Exception{
			throw new Exception("예외가 발생했습니다.");
	}
	
	@RequestMapping("/ex2")
	public String main2(Model model) throws NullPointerException{
			throw new NullPointerException("예외가 발생했습니다.");
	}

}
