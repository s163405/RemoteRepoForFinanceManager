package DBSample;

import java.util.Date;

public class Income {
	private int rid; // RIDを保存
	private UserData user;// userを保存
	private INCCat category;// 収入カテゴリを保存
	private Date date;// 入力日を保存
	private int amount;// 金額を保存
	private String memo;// メモテキストを保存
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public UserData getUser() {
		return user;
	}
	public void setUser(UserData user) {
		this.user = user;
	}
	public INCCat getCategory() {
		return category;
	}
	public void setCategory(INCCat category) {
		this.category = category;
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
