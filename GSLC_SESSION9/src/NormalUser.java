import java.util.Vector;

public class NormalUser extends User {
	KTP ktp = new KTP();

	public KTP getKtp() {
		return ktp;
	}

	public void setKtp(KTP ktp) {
			this.ktp = ktp;			
	}

	public NormalUser(String name, String gender, String status, Integer point, Vector<KTP> ktpList) {
		super(name, gender, status, point);
		// TODO Auto-generated constructor stub
			this.ktp = ktp;			
	}
	

	@Override
	public int generatePoint() {
		// TODO Auto-generated method stub
		int currentPoint = (int) (Math.random() * (this.getName().length())) + 1;
		
		return currentPoint;
	}
	
	
}
