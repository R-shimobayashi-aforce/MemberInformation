package jp.co.aforce.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignupAction extends Action {
	public String execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "Signup.jsp";
	}

}