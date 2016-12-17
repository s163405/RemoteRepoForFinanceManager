package DBSample;

import java.util.Date;

public class Expenses {
	private int rid; // RID��ۑ�
	private UserData user;// user��ۑ�
	private INCCat category;// �����J�e�S����ۑ�
	private Date date;// �x�o����ۑ�
	private int amount;// ���z��ۑ�
	private String place;//�x�o�ꏊ��ۑ�
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
