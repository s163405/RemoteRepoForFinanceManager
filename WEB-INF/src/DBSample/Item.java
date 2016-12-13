package DBSample;

public class Item {
	private int rid; // RIDを保存
	private String name; // アイテムの名前を保存
	private int price; // アイテムの価格を保存
	private String details; // アイテムの詳細情報を保存
	private int stock; // アイテムの在庫数を保存

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
