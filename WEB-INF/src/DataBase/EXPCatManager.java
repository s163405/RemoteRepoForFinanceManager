package DataBase;

import java.sql.ResultSet;//ResultSet���C���|�[�g
import java.util.LinkedList;//�����N�h���X�g���C���|�[�g
import DBSample.EXPCat; //INCCat�N���X���C���|�[�g

public class EXPCatManager extends DataBaseManager {

	public Object copyRecord(ResultSet rs) throws Exception {
		EXPCat eCat = new EXPCat();
		eCat.setRid(rs.getInt("RID"));
		eCat.setCategory(rs.getString("Category"));

		return eCat;
	}
//
//	public void insert(EXPCat eCat) {
//		String sql = "";
//		sql += "Insert into EXPCat (Category) values (";
//		sql += "'" + eCat.getCategory() + "'";
//		sql += ")";
//		updateRecord(sql); // SQL�����M
//
//	}

	public EXPCat get(int id) {
		String sql = "";
		sql += "select * from EXPCat where RID=";
		sql += id;
		EXPCat aExp = (EXPCat) getRecord(sql); // SQL�����M

		return aExp;
	}

	public LinkedList getEXPList() {
		String sql = "select * from EXPCat";
		LinkedList EXPCatList = getRecords(sql);

		return EXPCatList;
	}
//
//	public void delete(int id) {
//		String sql = "delete from ExpCat where RID=" + id;
//		updateRecord(sql);
//	}
//
//	public void update(EXPCat aEXPCat) {
//		String sql = "";
//		sql += "update ExpCat set Category=" + "'";
//		sql += aEXPCat.getCategory() + "'";
//		sql += " where RID=";
//		sql += aEXPCat.getRid();
//		updateRecord(sql); // SQL�����M
//
//	}

}
