import java.util.Vector;

public final class KTP {
	private String noKTP; // nomor KTP harus berupa angka dan panjangnya harus 5 digit

	public KTP() {
		// TODO Auto-generated constructor stub
	}

	public String getNoKTP() {
		return noKTP;
	}

	public boolean setNoKTP(String noKTP, Vector<KTP> ktpList) {
		
		char[] numbers = noKTP.toCharArray();
		
		for(char number : numbers) {
			if(!(number >= '0' && number <= '9' )) {
				System.out.println("KTP Number must only contain number and must 5 digit!");
				return false;
				
			}else if(noKTP.length() != 5) {
				System.out.println("KTP Number must only contain number and must 5 digit!");
				return false;
			}
		}
		
		for(KTP ktp : ktpList) {
			if(ktp.getNoKTP().equals(noKTP) == true) {
				System.out.println("KTP already registered!");
				return false;
			}
		}
		
		this.noKTP = noKTP;
		return true;
	}

}