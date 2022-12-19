import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	Scanner sc = new Scanner(System.in);
	ArrayList<User> user =  new ArrayList<>();
	Vector<KTP> ktpList = new Vector<>();
	KTP newKTP = new KTP();
	
	public Main() {
		// TODO Auto-generated constructor stub
		int choose;
		do {
			Menu();
			choose = sc.nextInt();
			sc.nextLine();
			
			switch(choose) {
			case 1: 
				view();
				break;
			case 2 :
				add();
				break;
			case 3 :
				delete();
				break;
			case 4 :
				buy();
				break;
			case 5 :
				break;
			}
			
		}while(choose != 5);
	}

	

	private void Menu() {
		// TODO Auto-generated method stub
		System.out.println("HELLO!!!");
		System.out.println("========");
		System.out.println("1. View All User");
		System.out.println("2. Add New User");
		System.out.println("3. Delete User");
		System.out.println("4. Buy Some Thing");
		System.out.println("5. Exit");
		System.out.println("Choose [1-5] :");
	}



	private void view() {
		// TODO Auto-generated method stub
		if(user.isEmpty()) {
			System.out.println("There are no user currently...");
			return;
		}else {
			int counter = 0;
			System.out.printf("%-4s | %-15s | %-10s | %-10s | %-8s | %-10s | %-10s | %-15s | %-15s | %-20s |\n", "No", "Name", "Gender", "Status", "Point", "ID", "No KTP", "Addres", "Username", "Email");
			
			for(User A : user) {
				counter++;
				if(A instanceof MemberUser) {
					System.out.printf("%-4s | %-15s | %-10s | %-10s | %-8s | %-10s | %-10s | %-15s | %-15s | %-20s |\n", counter, A.getName(), A.getGender(), A.getStatus(), A.getPoint(), ((MemberUser)A).calcID(), ((MemberUser)A).getKtp().getNoKTP(), ((MemberUser)A).getAddress(), ((MemberUser)A).getUsername(), ((MemberUser)A).getEmail());
				}else if(A instanceof NormalUser) {
					System.out.printf("%-4s | %-15s | %-10s | %-10s | %-8s | %-10s | %-10s | %-15s | %-15s | %-20s |\n", counter, A.getName(), A.getGender(), A.getStatus(), A.getPoint(), " - ", ((NormalUser)A).getKtp().getNoKTP(), " - ", " - " , " - ");
				}
			}
			
		}
		
	}



	private void add() {
		// TODO Auto-generated method stub
		String name = ""; // harus lebih besar dari 5 dan lebih kecil dari 15
		String gender = ""; // (antara “Male” atau “Female”) – Case Insensitive
		String status = ""; // (antara "Member" atau "Normal") - Case Insensitive
		Integer point = 0; // selalu nambah setiap melakukan pembelian
		String address = ""; // (terdiri 30 karakter) 
		String username = "";// (Minimal terdiri dari 1 kata dan - Maks. 10 karakter)
		String email = ""; // (harus berakhiran @user.com dan unik) – Maks. 20 karakter
		ID id = null;
		String noKTP = "";
		
		do {
			System.out.println("Input name: ");
			name = sc.nextLine();
		}while(name.length() < 5 || name.length() > 15);
		
		do {
			System.out.println("Input gender: ");
			gender = sc.nextLine();
		}while(!gender.equals("Male") && !gender.equals("Female"));
		
		do {
			System.out.println("Input status: ");
			status = sc.nextLine();
		}while(!status.equals("Member") && !status.equals("Normal"));
		
		if(status.equals("Member")) {
			
			while(true) {
				System.out.println("Input no KTP: ");
				noKTP = sc.nextLine();
				boolean continueFlag = newKTP.setNoKTP(noKTP, ktpList);
				
				if(continueFlag == true) {
					break;
				}
			}
			
			int word = 0;
			do {
				System.out.println("Input address: ");
				address = sc.nextLine();
				
			}while(name.length() < 1 || name.length() > 30);
			
			do {
				System.out.println("Input username: ");
				username = sc.nextLine();
				
			}while(word < 1 && name.length() > 15);
			
			do {
				System.out.println("Input email: ");
				email = sc.nextLine();
				
			}while(!email.endsWith("@user.com"));
			
			
				
			user.add(new MemberUser(name, gender, status, point, address, username, email, ktpList));
		}else {
			while(true) {
				System.out.println("Input no KTP: ");
				noKTP = sc.nextLine();
				boolean continueFlag = newKTP.setNoKTP(noKTP, ktpList);
				
				if(continueFlag == true) {
					break;
				}
			}
			user.add(new NormalUser(name, gender, status, point, ktpList));
		}
		
		System.out.println("a new user has been added");
		
	}



	private void delete() {
		// TODO Auto-generated method stub
		if(user.isEmpty()) {
			System.out.println("There are no user currently...");
			return;
		}else {
			int counter = 0;
			System.out.printf("%-4s | %-15s | %-10s | %-10s | %-8s | %-10s | %-10s | %-15s | %-15s | %-20s |\n", "No", "Name", "Gender", "Status", "Point", "ID", "No KTP", "Addres", "Username", "Email");
			
			for(User A : user) {
				counter++;
				if(A instanceof MemberUser) {
					System.out.printf("%-4s | %-15s | %-10s | %-10s | %-8s | %-10s | %-10s | %-15s | %-15s | %-20s |\n", counter, A.getName(), A.getGender(), A.getStatus(), A.getPoint(), ((MemberUser)A).calcID(), ((MemberUser)A).getKtp().getNoKTP(), ((MemberUser)A).getAddress(), ((MemberUser)A).getUsername(), ((MemberUser)A).getEmail());
				}else if(A instanceof NormalUser) {
					System.out.printf("%-4s | %-15s | %-10s | %-10s | %-8s | %-10s | %-10s | %-15s | %-15s | %-20s |\n", counter, A.getName(), A.getGender(), A.getStatus(), A.getPoint(), " - ", ((NormalUser)A).getKtp().getNoKTP(), " - ", " - " , " - ");
				}
			}
			
			String del;
			boolean found = false;
			do {
				System.out.println("Input name to be removed: ");
				del = sc.nextLine();

				for (int i = 0; i < user.size(); i++) {
					if (user.get(i).getName().equals(del)) {
						user.remove(i);
						found = true;
						break;
					}
				}
				if (del.equals("0")) {
					return;
				}
			} while (!found);
			if (found) {
				System.out.println("Delete Success");
			}
		
			System.out.println("Press ENTER to continue");
			sc.nextLine();
		}
	}



	private void buy() {
		// TODO Auto-generated method stub
		String tempName = "";
		if(user.isEmpty()) {
			System.out.println("There are no user currently...");
			return;
		}else {
			int counter = 0;
			System.out.printf("%-4s | %-15s | %-10s | %-10s | %-8s | %-10s | %-10s | %-15s | %-15s | %-20s |\n", "No", "Name", "Gender", "Status", "Point", "ID", "No KTP", "Addres", "Username", "Email");
			
			for(User A : user) {
				counter++;
				if(A instanceof MemberUser) {
					System.out.printf("%-4s | %-15s | %-10s | %-10s | %-8s | %-10s | %-10s | %-15s | %-15s | %-20s |\n", counter, A.getName(), A.getGender(), A.getStatus(), A.getPoint(), ((MemberUser)A).calcID(), ((MemberUser)A).getKtp().getNoKTP(), ((MemberUser)A).getAddress(), ((MemberUser)A).getUsername(), ((MemberUser)A).getEmail());
				}else if(A instanceof NormalUser) {
					System.out.printf("%-4s | %-15s | %-10s | %-10s | %-8s | %-10s | %-10s | %-15s | %-15s | %-20s |\n", counter, A.getName(), A.getGender(), A.getStatus(), A.getPoint(), " - ", ((NormalUser)A).getKtp().getNoKTP(), " - ", " - " , " - ");
				}
			}
			System.out.println("Input Name: ");
			tempName = sc.nextLine();
			
			for(User A : user) {
				if(A.getName().equals(tempName)) {
					A.setPoint(A.generatePoint());
					System.out.println("Thank you for buying!!!");
					return;
				}
			}
			System.out.println("There is no name with that name....");
		}
		
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
