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
			
			//�Ʒ��� �������� �����ϴ� �����͵���
			binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
			binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor("#"));
			// �Է��� ������� swimming#game#sleep �� ���, #�� �����ڷ� �Ͽ� String[]�� ��ҵ��� �и��� ����ִ´�. split �޼����� �����ϸ� ����.
	
//			setValidator�� ������ globalValidator�� �Ⱦ��� �ȴ�. ���� global�� ������ add�޼��带 �̿�����.
			binder.addValidators(new UserValidator());
//			����ϰ� �ִ� validator ��� ����ϱ�
			List<Validator> list = binder.getValidators();
			System.out.println("validator list ="+list);
//			binder.setValidator(new UserValidator());  // �ڵ� ���� - 1�ܰ�.
			
//			UserValidator�� �� ������ ���δ��� ����(��Ʈ�ѷ� ������ �۵�) validator�� ���
	
	
	}
	
//	@RequestMapping(value="/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save")  //������ 4.3���� �̿� ������. pom.xml�� properties���� �����ؾ���.
	
//	BindingResult�� ���ε� �� ��ü�� �ٷ� �ڿ� �;��Ѵ�. BR�� ��Ʈ�ѷ��� �ִ� ���, ���ܰ� �߻��ϸ� ���� �������� ���� ���� �ƴ϶�,
//	��Ʈ�ѷ����� ���ε� ����� �ְ� ��Ʈ�ѷ��� ��� ó���� �� ������ �� �ְ� �Ѵ�.
//	�ڵ� ���� - 2�ܰ� @Valid ������̼� ������ Valid API�� �ٿ�ε�.  maven repo���� validation �ڵ带 pom.xml�� �߰��� �� ������Ʈ.
	public String save(@Valid User user, BindingResult result, Model m) throws Exception {
		System.out.println("result="+result);
		
//		���� ���� - validator�� ���� �����ϰ� ���� ȣ���ϴ� ���
		UserValidator userValidator = new UserValidator();
		userValidator.validate(user, result);  // BindingResult�� errors�� �ڼ��̹Ƿ� result�� �̿��� �� �ִ�.
		
//		���� ������ �߻��ϸ� registerForm�� �̿��� ������ �����־�� �Ѵ�.
		if(result.hasErrors()) {
			return "registerForm";
		}
//		��ȿ�� �˻�
//		if(!isValid(user)) {
//			String msg = URLEncoder.encode("id�� �߸��Է��߽��ϴ�.", "utf-8");
//
//			m.addAttribute("msg",msg);         �Ѱ���� �� ���� ���� ���, �̷� ������� �߰��ؼ� ��������.
//			return "redirect:/register/add;  �ٵ� Model�� save���� �̿��� �����͸� ��� ���ε�, ������ redirect���� �𵨿� ��Ƽ� �����ϰ��� �Ѵ�.
//			�̴� spring�� �� �� ���� �Ʒ��� �ڵ�� �ڵ� ��ȯ���ֱ� ������ ������.
//			return "redirect:/register/add?msg=" + msg;
//		}
		return "registerInfo";
	}

private boolean isValid(User user) {
	
	return true;
}
}
