package DataBase;

import java.sql.ResultSet;//ResultSetをインポート
import java.util.LinkedList;//リンクドリストをインポート
import DBSample.Item; //アイテムクラスをインポート

public class ItemManager extends DataBaseManager {

	public Object copyRecord(ResultSet rs) throws Exception {
		Item item = new Item();
		item.setRid(rs.getInt("RID"));
		item.setName(rs.getString("Name"));
		item.setPrice(rs.getInt("Price"));
		item.setDetails(rs.getString("Details"));
		item.setStock(rs.getInt("Stock"));
		return item;
	}

	public void insert(Item aItem) {
		String sql = "";
		sql += "Insert into stockItem (Name,Price,Details,Stock) values (";
		sql += "'" + aItem.getName() + "'";
		sql += ",";
		sql += aItem.getPrice();
		sql += ",";
		sql += "'" + aItem.getDetails() + "'";
		sql += ",";
		sql += aItem.getStock();
		sql += ")";
		updateRecord(sql); // SQL文送信

	}

	public Item get(int id) {
		String sql = "";
		sql += "select * from stockItem where RID=";
		sql += id;
		Item aItem = (Item) getRecord(sql); // SQL文送信

		return aItem;
	}

	public LinkedList getList() {
		String sql = "select * from stockItem";
		LinkedList itemList = getRecords(sql);

		return itemList;
	}

	public void delete(int id) {
		String sql = "delete from stockItem where RID=" + id;
		updateRecord(sql);
	}

	public void update(Item aItem) {
		String sql = "";
		sql += "update stockItem set Name=" + "'";
		sql += aItem.getName() + "'";
		sql += ",";
		sql += " Price=";
		sql += aItem.getPrice();
		sql += ",";
		sql += " Details=" + "'";
		sql += aItem.getDetails() + "'";
		sql += ",";
		sql += " Stock=";
		sql += aItem.getStock();
		sql += " where RID=";
		sql += aItem.getRid();
		updateRecord(sql); // SQL文送信

	}

}
