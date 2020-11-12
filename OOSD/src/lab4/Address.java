package lab4;

public class Address extends Object {
	//variables
	private String street;
	private String city;
	private String county;
	
	//constructor
	public Address(String street, String city, String county) {
		setStreet  (street);
		setCity  (city);
		setCounty (county);
	}

	//getters&setters
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}

	
	//toString
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", county=" + county + "]";
	}
	
	
}
