package DBSample;

import java.util.Date;

public class Expenses {
	private int rid; // RID��ۑ�
	private UserData user;// user��ۑ�
	private INCCat category;// �����J�e�S����ۑ�
	private int year;// �N
	private int month;// ��
	private int day;// ��
	private int amount;// ���z��ۑ�
	private String place;// �x�o�ꏊ��ۑ�
	private String memo;// �����e�L�X�g��ۑ�

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
