package com.kiseo.www;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.equals(clazz);  // 검증하려는 클래스의 타입을 먼저 검사한다.
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("UserValidator.validate() is called");
		User user = (User)target;
		
		String id = user.getId();
//		필드 이름은 id, pwd이며 에러 코드를 required로 작성한다. 
//		이후 다른 파일에서 해당 에러코드의 응답을 출력하도록 하자.
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "required");
		
		
	}
}
