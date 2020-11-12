package prep2;

public class Item {
	//Variables
	private int itemID;
	private static int nextItemID=0;
	private String name;
	private String type;
	private String date;
	private char status;
	private double price;
	private static int nOfsalesItems=0;

	
	//Constructors
	public Item(String name, String type, String date, double price, char status) {
		++nextItemID;
		setItemID(nextItemID);
		setName (name);
		setType (type);
		setDate (date);
		setPrice (price);
		setStatus(status);
		nOfsalesItems++;
		
	}
	
	
	
	//Getter&Setters
	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public static int getnOfsalesItems() {
		return nOfsalesItems;
	}
	
	//Misc Methods
	public void statusUpdate() {
		setStatus('S');
	}


	//toString
	public String toString() {
		if(status=='A') {
		return "Item [itemID=" + itemID + ", name=" + name + ", type=" + type + ", date=" + date + ", status=" + status
				+ ", price=" + price + "]";
		}
		else {
			return "Item [itemID=" + itemID + ", name=" + name + ", type=" + type + ", date=" + date + ", status=" + status
					+  "]";
		}
	}
	
	
	
	
	
	
}
