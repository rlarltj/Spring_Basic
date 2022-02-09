package com.kiseo.www;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionController2 {

	

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@RequestMapping("/ex3")
	public String main(Model model) throws Exception{
			throw new MyException("���ܰ� �߻��߽��ϴ�.");
	}
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@RequestMapping("/ex4")
	public String main2(Model model) throws NullPointerException{
			throw new NullPointerException("���ܰ� �߻��߽��ϴ�.");
	}

}


class MyException extends RuntimeException{
	MyException(String msg){
		super(msg);
	}
	MyException(){
		this("");
	}
}