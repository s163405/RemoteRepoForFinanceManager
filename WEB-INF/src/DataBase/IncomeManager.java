package DataBase;

import java.sql.ResultSet;//ResultSetをインポート
import java.util.LinkedList;//リンクドリストをインポート

import DBSample.INCCat;
import DBSample.Income; //Incomeクラスをインポート
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
		sql += "'"+aInc.getMemo()+"'";
		sql += ")";
		updateRecord(sql); // SQL文送信

	}

	public Income get(int id) {
		String sql = "";
		sql += "select * from Income where RID=";
		sql += id;
		Income aInc = (Income) getRecord(sql); // SQL文送信

		return aInc;
	}

	public LinkedList getINCList() {
		String sql = "select * from Income";
		LinkedList INCList = getRecords(sql);

		return INCList;
	}

	public LinkedList getINCList(int year, int month) {
		String sql = "select * from Income where Year="+year+" AND Month="+month;
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
		updateRecord(sql); // SQL文送信

	}

}
