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
		inc.setDate(rs.getDate("Date"));
		inc.setAmount(rs.getInt("Amount"));
		inc.setMemo(rs.getString("Memo"));

		UserDataManager um=new UserDataManager();
		UserData user=um.get(userRid);
		inc.setUser(user);

		INCCatManager iCat = new INCCatManager();
		INCCat categoryName = iCat.getCategory(categoryRid);
		inc.setCategory(categoryName);


		return inc;
	}

	//
	// public void insert(Income aInc) {
	// String sql = "";
	// sql += "Insert into Income (UserRID, CategoryRID, Date, Amount, Memo)
	// values (";
	// sql += "'" + aInc.getUserRID() + "'";
	// sql += ",";
	// sql += aInc.getCategoryRID();
	// sql += ",";
	// sql += "'" + aInc.getDate() + "'";
	// sql += ",";
	// sql += aInc.getAmount();
	// sql += ",";
	// sql += aInc.getMemo();
	// sql += ")";
	// updateRecord(sql); // SQL文送信
	//
	// }
	//
	public Income get(int id) {
		String sql = "";
		sql += "select * from Income where RID=";
		sql += id;
		Income aInc = (Income) getRecord(sql); // SQL文送信

		return aInc;
	}

	public LinkedList getINCList() {
		String sql = "select * from Imcome";
		LinkedList INCList = getRecords(sql);

		return INCList;
	}

	public void delete(int id) {
		String sql = "delete from stockItem where RID=" + id;
		updateRecord(sql);
	}
	//
	// public void update(Income aInc) {
	// String sql = "";
	// sql += "update Income set UserRID=" + "'";
	// sql += aInc.getUserRID() + "'";
	// sql += ",";
	// sql += " CategoryRID=";
	// sql += aInc.getCategoryRID();
	// sql += ",";
	// sql += " Date=" + "'";
	// sql += aInc.getDate() + "'";
	// sql += ",";
	// sql += " Amount=";
	// sql += aInc.getAmount();
	// sql += ",";
	// sql += " Memo=";
	// sql += aInc.getMemo();
	// sql += " where RID=";
	// sql += aInc.getRid();
	// updateRecord(sql); // SQL文送信
	//
	// }

}
