import java.util.Scanner;

public class LoginSystem implements AccountList {

	Scanner scan;
	Seller seller;
	Customer customer;
	final String TEXT_RED = "\u001B[31m";
	final String TEXT_YELLOW = "\u001B[33m";
	final String TEXT_PURPLE = "\u001B[35m";

	public LoginSystem(){
		scan = new Scanner(System.in);
		seller = new Seller();
		customer = new Customer();
	}

	void login(){
		String name, pass;
		int option;

		if (loginSeller.size() != 0 || loginCustomer.size() != 0) {
			System.out.println(TEXT_PURPLE+"\t\t\t\t\t\t\t+=========================+");
			System.out.println(TEXT_YELLOW+"\t\t\t\t\t\t\t|         Login As        |");
			System.out.println(TEXT_PURPLE+"\t\t\t\t\t\t\t+=========================+");
			System.out.println(TEXT_YELLOW+"\t\t\t\t\t\t\t|   1. Customer           |");
			System.out.println(TEXT_YELLOW+"\t\t\t\t\t\t\t|   2. Seller             |");
			System.out.println(TEXT_YELLOW+"\t\t\t\t\t\t\t|   3. Exit               |");
			System.out.println(TEXT_PURPLE+"\t\t\t\t\t\t\t+=========================+");

			do{
				System.out.print(TEXT_YELLOW+"\t\t\t\t\t\t\t\t Choose: ");
				option = scanInt();

			}while(option <1 || option >3);
			if(option == 3){
				return;
			}
			if(option == 1){
				if(loginCustomer.size() == 0){
					System.out.println(TEXT_RED+"\n\t\t\t\t\t  There's no Customer Account yet! Please Register first.\n");
					System.out.println(TEXT_RED+"\t\t\t\t\t\t\t Press enter to continue...");
					scan.nextLine();
					return;
				}
				do {
					System.out.print(TEXT_YELLOW+"Input account name [6-20 character] : ");
					name = scan.nextLine();
					if(!loginCustomer.containsKey(name)){
						System.out.println(TEXT_RED+"\n\t\t\t\t\t\t    Invalid Username. Please Try Again.\n");
					}
				}while(!loginCustomer.containsKey(name));
				do {
					System.out.print(TEXT_YELLOW+"Input account password [6-20 character]: ");
					pass = scan.nextLine();
					if(!loginCustomer.containsValue(pass)){
						System.out.println(TEXT_RED+"\n\t\t\t\t\t\t    Invalid Password. Please Try Again.\n");
					}
				}while(!loginCustomer.containsValue(pass));
				customer.customer();
			}
			if(option == 2){
				if(loginSeller.size() == 0){
					System.out.println(TEXT_RED+"\n\t\t\t\t\t   There's no Seller Account yet! Please Register first.\n");
					System.out.println(TEXT_RED+"\t\t\t\t\t\t\t Press enter to continue...");
					scan.nextLine();
					return;
				}
				do {
					System.out.print(TEXT_YELLOW+"Input account name [6-20 character] : ");
					name = scan.nextLine();
					if(!loginSeller.containsKey(name)){
						System.out.println(TEXT_RED+"\n\t\t\t\t\t\t    Invalid Username. Please Try Again.");
					}
				}while(!loginSeller.containsKey(name));
				do {
					System.out.print(TEXT_YELLOW+"Input account password [6-20 character]: ");
					pass = scan.nextLine();
					if(!loginSeller.containsValue(pass)){
						System.out.println(TEXT_RED+"\n\t\t\t\t\t\t    Invalid Password. PLease Try Again.");
					}
				}while(!loginSeller.containsValue(pass));
				seller.seller();
			}
		}
		else {
			System.out.println(TEXT_RED+"\n\t\t\t\t     There's no Customer or Seller Account yet! Please Register first.\n");
			System.out.println(TEXT_RED+"\t\t\t\t\t\t\t Press enter to continue...");
			scan.nextLine();
		}
	}

	int scanInt() {
		int input;
		try {
			input = scan.nextInt();
		}catch (Exception e) {
			input = Integer.MIN_VALUE;
		} scan.nextLine();
		return input;
	}
}