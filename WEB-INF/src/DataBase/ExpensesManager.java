package DataBase;

import java.sql.ResultSet;//ResultSetをインポート
import java.util.LinkedList;//リンクドリストをインポート

import DBSample.INCCat;
import DBSample.Expenses; //Expensesクラスをインポート
import DBSample.UserData;

public class ExpensesManager extends DataBaseManager {

	public Object copyRecord(ResultSet rs) throws Exception {
		Expenses exp = new Expenses();
		exp.setRid(rs.getInt("RID"));
		int userRid = rs.getInt("UserRID");
		int categoryRid = rs.getInt("CategoryRID");
		exp.setDate(rs.getDate("Date"));
		exp.setAmount(rs.getInt("Amount"));
		exp.setPlace(rs.getString("Place"));
		exp.setMemo(rs.getString("Memo"));

		UserDataManager um = new UserDataManager();
		UserData user = um.get(userRid);
		exp.setUser(user);

		INCCatManager iCat = new INCCatManager();
		INCCat categoryName = iCat.getCategory(categoryRid);
		exp.setCategory(categoryName);

		return exp;
	}

	public void insert(Expenses aExp) {
		String sql = "";
		sql += "Insert into Income (UserRID, CategoryRID, Date, Amount, Place, Memo) values (";
		sql += "'" + aExp.getUser().getRid() + "'";
		sql += ",";
		sql += aExp.getCategory().getRid();
		sql += ",";
		sql += "'" + aExp.getDate() + "'";
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
		sql += "update Income set UserRID=" + "'";
		sql += aExp.getUser().getRid() + "'";
		sql += ",";
		sql += " CategoryRID=";
		sql += aExp.getCategory().getRid();
		sql += ",";
		sql += " Date=" + "'";
		sql += aExp.getDate() + "'";
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
