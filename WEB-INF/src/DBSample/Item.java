package DBSample;

public class Item {
	private int rid; // RID��ۑ�
	private String name; // �A�C�e���̖��O��ۑ�
	private int price; // �A�C�e���̉��i��ۑ�
	private String details; // �A�C�e���̏ڍ׏���ۑ�
	private int stock; // �A�C�e���̍݌ɐ���ۑ�

	// getter and setter
	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
