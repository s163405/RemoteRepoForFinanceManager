package DataBase;

import java.sql.ResultSet;//ResultSet���C���|�[�g
import java.util.LinkedList;//�����N�h���X�g���C���|�[�g

import DBSample.INCCat;
import DBSample.Income; //Income�N���X���C���|�[�g
import DBSample.UserData;

public class IncomeManager extends DataBaseManager {

	public Object copyRecord(ResultSet rs) throws Exception {
		Income inc = new Income();
		inc.setRid(rs.getInt("RID"));
		int userRid = rs.getInt("UserRID");
		int categoryRid = rs.getInt("CategoryRID");
		inc.setYear(rs.getInt("Year"));
		inc.setMonth(rs.getInt("Month"));
		inc.setDay(rs.getInt("Day"));
		inc.setAmount(rs.getInt("Amount"));
		inc.setMemo(rs.getString("Memo"));

		UserDataManager um = new UserDataManager();
		UserData user = um.get(userRid);
		inc.setUser(user);

		INCCatManager iCat = new INCCatManager();
		INCCat category = iCat.get(categoryRid);
		String categoryName = category.getCategory();
		System.out.println(categoryName);
		inc.setCategory(category);

		return inc;
	}

	public void insert(Income aInc) {
		String sql = "";
		sql += "Insert into Income (UserRID, CategoryRID, Year, Month, Day, Amount, Memo) values (";
		sql += "'" + aInc.getUser().getRid() + "'";
		sql += ",";
		sql += aInc.getCategory().getRid();
		sql += ",";
		sql += "'" + aInc.getYear() + "'";
		sql += ",";
		sql += "'" + aInc.getMonth() + "'";
		sql += ",";
		sql += "'" + aInc.getDay() + "'";
		sql += ",";
		sql += aInc.getAmount();
		sql += ",";
		sql += "'" + aInc.getMemo() + "'";
		sql += ")";
		updateRecord(sql); // SQL�����M

	}

	public Income get(UserData ud, int id) {
		String sql = "";
		sql += "select * from Income where UserRid=" + ud.getRid() + " AND RID=";
		sql += id;
		sql += " ORDER BY Year, Month, Day";

		Income aInc = (Income) getRecord(sql); // SQL�����M

		return aInc;
	}

	// public LinkedList getINCList() {
	// String sql = "select * from Income";
	// LinkedList INCList = getRecords(sql);
	//
	// return INCList;
	// }

	public LinkedList getINCList(UserData ud, int year, int month) {
		String sql = "select * from Income where UserRid=" + ud.getRid() + " AND Year=" + year + " AND Month=" + month;
		sql += " ORDER BY Year, Month, Day";
		LinkedList INCList = getRecords(sql);

		return INCList;
	}

	// public LinkedList getINCListCat(int year, int month, int catRID) {
	// String sql = "select * from Income where Year=" + year + " AND Month=" +
	// month + " AND CategoryRID=" + catRID;
	// LinkedList INCList = getRecords(sql);
	//
	// return INCList;
	// }

	public LinkedList getINCListCat(UserData ud, int year, int month, int catRID) {
		String sql = "select * from Income where UserRid=" + ud.getRid() + " AND Year=" + year + " AND Month=" + month
				+ " AND CategoryRID=" + catRID;
		sql += " ORDER BY Year, Month, Day";
		LinkedList INCList = getRecords(sql);

		return INCList;
	}

	public void delete(int id) {
		String sql = "delete from Income where RID=" + id;
		updateRecord(sql);
	}

	public void update(Income aInc) {
		String sql = "";
		sql += "update Income set UserRID=" + "'";
		sql += aInc.getUser().getRid() + "'";
		sql += ",";
		sql += " CategoryRID=";
		sql += aInc.getCategory().getRid();
		sql += ",";
		sql += " Year=" + "'";
		sql += aInc.getYear() + "'";
		sql += ",";
		sql += " Month=" + "'";
		sql += aInc.getMonth() + "'";
		sql += ",";
		sql += " Day=" + "'";
		sql += aInc.getDay() + "'";
		sql += ",";
		sql += " Amount=";
		sql += aInc.getAmount();
		sql += ",";
		sql += " Memo='";
		sql += aInc.getMemo();
		sql += "' where RID=";
		sql += aInc.getRid();
		updateRecord(sql); // SQL�����M

	}

}
