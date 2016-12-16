package DataBase;

import java.sql.ResultSet;//ResultSet���C���|�[�g
import java.util.LinkedList;//�����N�h���X�g���C���|�[�g
import DBSample.INCCat; //INCCat�N���X���C���|�[�g

public class INCCatManager extends DataBaseManager {

	public Object copyRecord(ResultSet rs) throws Exception {
		INCCat iCat = new INCCat();
		iCat.setRid(rs.getInt("RID"));
		iCat.setCategory(rs.getString("Category"));

		return iCat;
	}
//
//	public void insert(INCCat iCat) {
//		String sql = "";
//		sql += "Insert into stockItem (Category) values (";
//		sql += "'" + iCat.getCategory() + "'";
//		sql += ")";
//		updateRecord(sql); // SQL�����M
//
//	}

	public INCCat get(int id) {
		String sql = "";
		sql += "select * from INCCat where RID=";
		sql += id;
		INCCat aInc = (INCCat) getRecord(sql); // SQL�����M

		return aInc;
	}

	public LinkedList getINCList() {
		String sql = "select * from INCCat";
		LinkedList INCCatList = getRecords(sql);

		return INCCatList;
	}
//
//	public void delete(int id) {
//		String sql = "delete from INCCat where RID=" + id;
//		updateRecord(sql);
//	}
//
//	public void update(INCCat aINCCat) {
//		String sql = "";
//		sql += "update INCCat set Category=" + "'";
//		sql += aINCCat.getCategory() + "'";
//		sql += " where RID=";
//		sql += aINCCat.getRid();
//		updateRecord(sql); // SQL�����M
//
//	}

}
