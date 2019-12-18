package classes;

public class Home {
	
	private int homeId;
	private int userId;
	private String address1;
	private String address2 = "";
	private String city;
	private String state;
	private int zip;
	private int yearBuilt;
	private double homeValue;
	
	public Home(int homeId, int userId, String address1, String city, String state, int zip, int yearBuilt,
				double homeValue) {
		this.homeId = homeId;
		this.userId = userId;
		this.address1 = address1;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.yearBuilt = yearBuilt;
		this.homeValue = homeValue;
	}
	public Home() {
		
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public int getYearBuilt() {
		return yearBuilt;
	}

	public void setYearBuilt(int yearBuilt) {
		this.yearBuilt = yearBuilt;
	}

	public double getHomeValue() {
		return homeValue;
	}

	public void setHomeValue(double homeValue) {
		this.homeValue = homeValue;
	}

	public int getHomeId() {
		return homeId;
	}

	public int getUserId() {
		return userId;
	}
}
