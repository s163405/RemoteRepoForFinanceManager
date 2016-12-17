package DBSample;

import java.util.Date;

public class Income {
	private int rid; // RIDを保存
	private UserData user;// userを保存
	private INCCat category;// 収入カテゴリを保存
	private int Year;// 年
	private int Month;// 月
	private int Day;// 日
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

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public int getMonth() {
		return Month;
	}

	public void setMonth(int month) {
		Month = month;
	}

	public int getDay() {
		return Day;
	}

	public void setDay(int day) {
		Day = day;
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
