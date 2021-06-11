package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import jp.co.aforce.beans.Member;

public class Memberdao extends dao {

	public boolean insert(Member member) throws Exception {

		Connection con = getConnection();

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmss");
		String memberNo = "A" + sdf.format(date);
		PreparedStatement st;
		st = con.prepareStatement("insert into members values (?,?,?,?,?,?)");
		st.setString(1, memberNo);
		st.setString(2, member.getName());
		st.setInt(3, member.getAge());
		st.setInt(4, member.getBirth_year());
		st.setInt(5, member.getBirth_month());
		st.setInt(6, member.getBirth_day());
		int line = st.executeUpdate();
		boolean result = false;

		if (line > 0) {
			result = true;
		}
		st.close();
		con.close();
		return result;

	}

	

}
