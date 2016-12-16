package DataBase;

import java.sql.ResultSet;//ResultSet���C���|�[�g
import java.util.LinkedList;//�����N�h���X�g���C���|�[�g
import DBSample.Income; //Income�N���X���C���|�[�g

public class IncomeManager extends DataBaseManager {

	public Object copyRecord(ResultSet rs) throws Exception {
		Income inc = new Income();
		inc.setRid(rs.getInt("RID"));
		inc.setUserRID(rs.getInt("UserRID"));
		inc.setCategoryRID(rs.getInt("CategoryRID"));
		inc.setDate(rs.getDate("Date"));
		inc.setAmount(rs.getInt("Amount"));
		inc.setMemo(rs.getString("Memo"));
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
	// updateRecord(sql); // SQL�����M
	//
	// }
	//
	public Income get(int id) {
		String sql = "";
		sql += "select * from Income where RID=";
		sql += id;
		Income aInc = (Income) getRecord(sql); // SQL�����M

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
	// updateRecord(sql); // SQL�����M
	//
	// }

}
