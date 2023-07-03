package util;

public class Order {

	private Long id;
	
	private String name;
	
	private int price;
	
	private String date;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String getDate() {
		return date;
	}
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", price=" + price + ", date=" + date + "]";
	}

	public Order(Long id, String name, int price, String date) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.date = date;
	}
}
