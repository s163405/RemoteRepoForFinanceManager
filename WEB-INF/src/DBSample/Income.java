package DBSample;

import java.util.Date;

public class Income {
	private int rid; // RIDを保存
	private int userRID;// userのRIDを保存
	private int categoryRID;// 収入カテゴリのRIDを保存
	private Date date;// 入力日を保存
	private int amount;// 金額を保存
	private String memo;// メモテキストを保存

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getUserRID() {
		return userRID;
	}

	public void setUserRID(int userRID) {
		this.userRID = userRID;
	}

	public int getCategoryRID() {
		return categoryRID;
	}

	public void setCategoryRID(int categoryRID) {
		this.categoryRID = categoryRID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
