package DataBase;

import java.sql.ResultSet;//ResultSetをインポート
import java.time.LocalDateTime;
import java.util.LinkedList;//リンクドリストをインポート

import DBSample.EXPCat;
import DBSample.Expenses; //Expensesクラスをインポート
import DBSample.UserData;

public class ExpensesManager extends DataBaseManager {

	public Object copyRecord(ResultSet rs) throws Exception {
		Expenses exp = new Expenses();
		exp.setRid(rs.getInt("RID"));
		int userRid = rs.getInt("UserRID");
		int categoryRid = rs.getInt("CategoryRID");
		exp.setYear(rs.getInt("Year"));
		exp.setMonth(rs.getInt("Month"));
		exp.setDay(rs.getInt("Day"));
		exp.setAmount(rs.getInt("Amount"));
		exp.setPlace(rs.getString("Place"));
		exp.setMemo(rs.getString("Memo"));

		UserDataManager um = new UserDataManager();
		UserData user = um.get(userRid);
		exp.setUser(user);

		EXPCatManager eCat = new EXPCatManager();
		System.out.println("EXP.categoryRid=" + categoryRid);
		EXPCat category = eCat.get(categoryRid);
		String categoryName = category.getCategory();
		System.out.println(categoryName);
		exp.setCategory(category);

		return exp;
	}

	public void insert(Expenses aExp) {
		String sql = "";
		sql += "Insert into Expenses (UserRID, CategoryRID, Year, Month, Day, Amount, Place, Memo) values (";
		sql += "'" + aExp.getUser().getRid() + "'";
		sql += ",";
		sql += aExp.getCategory().getRid();
		sql += ",";
		sql += "'" + aExp.getYear() + "'";
		sql += ",";
		sql += "'" + aExp.getMonth() + "'";
		sql += ",";
		sql += "'" + aExp.getDay() + "'";
		sql += ",";
		sql += aExp.getAmount();
		sql += ",";
		sql += aExp.getPlace();
		sql += ",";
		sql += aExp.getMemo();
		sql += ")";
		updateRecord(sql); // SQL文送信

	}

	public Expenses get(int id) {
		String sql = "";
		sql += "select * from Expenses where RID=";
		sql += id;
		Expenses aInc = (Expenses) getRecord(sql); // SQL文送信

		return aInc;
	}

	public LinkedList getEXPList() {
		String sql = "select * from Expenses";
		LinkedList EXPList = getRecords(sql);

		return EXPList;
	}

	public void delete(int id) {
		String sql = "delete from Expenses where RID=" + id;
		updateRecord(sql);
	}

	public void update(Expenses aExp) {

		String sql = "";
		sql += "update Expenses set UserRID=" + "'";
		sql += aExp.getUser().getRid() + "'";
		sql += ",";
		sql += " CategoryRID=";
		sql += aExp.getCategory().getRid();
		sql += ",";
		sql += " Year=" + "'";
		sql += aExp.getYear() + "'";
		sql += ",";
		sql += " Month=" + "'";
		sql += aExp.getMonth() + "'";
		sql += ",";
		sql += " Day=" + "'";
		sql += aExp.getDay() + "'";
		sql += ",";
		sql += " Amount=";
		sql += aExp.getAmount();
		sql += ",";
		sql += " Place=";
		sql += aExp.getPlace();
		sql += ",";
		sql += " Memo=";
		sql += aExp.getMemo();
		sql += " where RID=";
		sql += aExp.getRid();
		updateRecord(sql); // SQL文送信

	}

}
