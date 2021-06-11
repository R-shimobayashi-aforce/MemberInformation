package jp.co.aforce.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.Member;
import jp.co.aforce.dao.Memberdao;

public class InsertAction extends Action {

	public String execute(
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		String msg = null;
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		int birth_year = Integer.parseInt(request.getParameter("year"));
		int birth_month = Integer.parseInt(request.getParameter("month"));
		int birth_day = Integer.parseInt(request.getParameter("day"));

		if (name == null || name == "" ) {
			msg = "入力されていない項目があります。";
		} else {
			Member m = new Member();
			m.setName(name);
			m.setAge(age);
			m.setBirth_year(birth_year);
			m.setBirth_month(birth_month);
			m.setBirth_day(birth_day);
			Memberdao dao = new Memberdao();

			boolean result = dao.insert(m);
			if (result) {
				msg = "登録に成功しました。";
			} else {
				msg = "登録に失敗しました。";
			}
		}
		request.setAttribute("msg", msg);
		return "Signup.jsp";
	}

}
