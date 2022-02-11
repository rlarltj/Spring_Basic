package com.kiseo.www;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.equals(clazz);  // �����Ϸ��� Ŭ������ Ÿ���� ���� �˻��Ѵ�.
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("UserValidator.validate() is called");
		User user = (User)target;
		
		String id = user.getId();
//		�ʵ� �̸��� id, pwd�̸� ���� �ڵ带 required�� �ۼ��Ѵ�. 
//		���� �ٸ� ���Ͽ��� �ش� �����ڵ��� ������ ����ϵ��� ����.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required");
		
		
	}
}
