import java.util.Vector;

public class MemberUser extends User implements ID{
	private String address; // (terdiri 30 karakter) 
	private String username;// (Minimal terdiri dari 1 kata dan - Maks. 10 karakter)
	private String email; // (harus berakhiran @user.com dan unik) – Maks. 20 karakter
	KTP ktp = new KTP();
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public KTP getKtp() {
		return ktp;
	}

	public void setKtp(KTP ktp) {
		this.ktp = ktp;			
	}
	
	public MemberUser(String name, String gender, String status, Integer point, String address, String username, String email, Vector<KTP> ktpList) {
		super(name, gender, status, point);
		// TODO Auto-generated constructor stub
		this.address = address;
		this.username = username;
		this.email = email;
		this.ktp = ktp;			

	}
	
	@Override
	public int generatePoint() {
		// TODO Auto-generated method stub
		int currentPoint = (int) (Math.random() * (this.getName().length() * 2)) + 1;
		
		return currentPoint;
	}
	
	public String calcID() {
		String id = "ID";
		for(int i = 0; i < 3; i++) {
			int temp = (int)((Math.random()*(3-1)) + 1);
			id += temp;
		}
		return id;
	}
	
	
}
