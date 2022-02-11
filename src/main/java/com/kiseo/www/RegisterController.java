package com.kiseo.www;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
//	@RequestMapping("/register/add")
//	@GetMapping("/register/add")
//	public String register() {
//		return "registerForm";
//	}
	
	@InitBinder
	public void toDate(WebDataBinder binder) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			
			//아래는 스프링이 제공하는 에디터들임
			binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
			binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
			// 입력이 예를들어 swimming#game#sleep 인 경우, #을 구분자로 하여 String[]에 요소들을 분리해 집어넣는다. split 메서드라고 생각하면 쉽다.
	
//			setValidator가 있으면 globalValidator를 안쓰게 된다. 따라서 global을 쓰려면 add메서드를 이용하자.
			binder.addValidators(new UserValidator());
//			사용하고 있는 validator 목록 출력하기
			List<Validator> list = binder.getValidators();
			System.out.println("validator list ="+list);
//			binder.setValidator(new UserValidator());  // 자동 검증 - 1단계.
			
//			UserValidator를 웹 데이터 바인더의 로컬(컨트롤러 내에서 작동) validator로 등록
	
	
	}
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save")  //스프링 4.3부터 이용 가능함. pom.xml의 properties에서 변경해야함.
	
//	BindingResult는 바인딩 할 객체의 바로 뒤에 와야한다. BR이 컨트롤러에 있는 경우, 예외가 발생하면 에러 페이지로 가는 것이 아니라,
//	컨트롤러에게 바인딩 결과를 주고 컨트롤러가 어떻게 처리할 지 결정할 수 있게 한다.
//	자동 검증 - 2단계 @Valid 어노테이션 설정과 Valid API를 다운로드.  maven repo에서 validation 코드를 pom.xml에 추가한 뒤 업데이트.
	public String save(@Valid User user, BindingResult result, Model m) throws Exception {
		System.out.println("result="+result);
		
//		수동 검증 - validator를 직접 생성하고 직접 호출하는 방식
		UserValidator userValidator = new UserValidator();
		userValidator.validate(user, result);  // BindingResult도 errors의 자손이므로 result를 이용할 수 있다.
		
//		만약 에러가 발생하면 registerForm을 이용해 에러를 보여주어야 한다.
		if(result.hasErrors()) {
			return "registerForm";
		}
//		유효성 검사
//		if(!isValid(user)) {
//			String msg = URLEncoder.encode("id를 잘못입력했습니다.", "utf-8");
//
//			m.addAttribute("msg",msg);         넘겨줘야 할 값이 많은 경우, 이런 방식으로 추가해서 전송하자.
//			return "redirect:/register/add;  근데 Model은 save에서 이용할 데이터를 담는 것인데, 지금은 redirect지만 모델에 담아서 전송하고자 한다.
//			이는 spring이 위 두 줄을 아래의 코드로 자동 변환해주기 때문에 괜찮다.
//			return "redirect:/register/add?msg=" + msg;
//		}
		return "registerInfo";
	}

private boolean isValid(User user) {
	
	return true;
}
}
