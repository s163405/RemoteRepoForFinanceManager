package DBSample;

import java.util.Date;

public class Income {
	private int rid; // RID��ۑ�
	private int userRID;// user��RID��ۑ�
	private int categoryRID;// �����J�e�S����RID��ۑ�
	private Date date;// ���͓���ۑ�
	private int amount;// ���z��ۑ�
	private String memo;// �����e�L�X�g��ۑ�

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
