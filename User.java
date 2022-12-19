
public abstract class User {
	private String name; // harus lebih besar dari 5 dan lebih kecil dari 15
	private String gender; // (antara “Pria” atau “Wanita”) – Case Insensitive
	private String status; // (antara "Member" atau "Normal") - Case Insensitive
	private Integer point; // selalu nambah setiap melakukan pembelian
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public User(String name, String gender, String status, Integer point) {
		super();
		this.name = name;
		this.gender = gender;
		this.status = status;
		this.point = point;
	}
	
	public abstract int generatePoint();
	
	
}
