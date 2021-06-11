package jp.co.aforce.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.dao.Memberdao;

public class ChangeAction {
	public String execute(
			HttpServletRequest request, HttpServletResponse response
			)throws Exception{
		
		HttpSession session=request.getSession();
		
		String keyword=request.getParameter("member_no");
		if(keyword==null) keyword="";
		
		Memberdao dao=new Memberdao();
		List<members> list=dao.search(member_no);
		
		session.setAttribute("list", list);
	
		return "Change.jsp";
	}
}
