package com.kiseo.www;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("init() method");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service() method");
	}

	@Override
	public void destroy() {
//		뒷정리. 서블릿이 메모리에서 제거될 때 서블릿 컨테이너에 의해 자동 호출됨.
		System.out.println("destroy() method");
	}


}
