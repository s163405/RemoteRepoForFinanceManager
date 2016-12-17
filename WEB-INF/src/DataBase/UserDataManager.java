package DataBase;

import java.sql.ResultSet;//ResultSet���C���|�[�g
import DBSample.UserData; //User�N���X���C���|�[�g

public class UserDataManager extends DataBaseManager {

	public Object copyRecord(ResultSet rs) throws Exception {
		UserData user = new UserData();
		user.setRid(rs.getInt("RID"));
		user.setUserID(rs.getString("UserID"));
		user.setPassWord(rs.getString("PassWord"));

		return user;
	}

	public UserData get(String id,String pw) {
		String sql = "";
		sql += "SELECT * FROM UserData WHERE UserID='"+id+"' AND PassWord='"+pw+"'";
		System.out.println(sql);
		UserData aUser = (UserData) getRecord(sql); // SQL�����M

		return aUser;
	}

	public UserData get(int rid) {
		String sql = "";
		sql += "SELECT * FROM UserData WHERE RID="+rid+"";
		System.out.println(sql);
		UserData aUser = (UserData) getRecord(sql); // SQL�����M

		return aUser;
	}

}

