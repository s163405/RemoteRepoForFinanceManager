package DBSample;

import java.util.Date;

public class Expenses {
	private int rid; // RIDを保存
	private UserData user;// userを保存
	private INCCat category;// 収入カテゴリを保存
	private int year;// 年
	private int month;// 月
	private int day;// 日
	private int amount;// 金額を保存
	private String place;// 支出場所を保存
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
