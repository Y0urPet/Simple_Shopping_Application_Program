import java.util.Scanner;

public class Admin implements AccountList{

    Scanner scan;
    final String TEXT_RESET = "\u001B[0m";
    final String TEXT_RED = "\u001B[31m";
    final String TEXT_PURPLE = "\u001B[35m";
    final String TEXT_CYAN = "\u001B[36m";


    Admin(){
        scan = new Scanner(System.in);
    }

    void admin(){
        int input;
        do {
            printMenuAdmin();
            System.out.print("\t\t\t\t\t\t\t\t Choose: ");
            input = scanInt();
            if(input == 1){
                showAccount();
            }
            if(input == 2){
                deleteAccount();
            }
            if(input == 3){
                clearAccount();
            }
        }while(input != 4);
    }

    void showAccount(){
        int input;
        do {
            System.out.println(TEXT_PURPLE+"\t\t\t\t\t\t\t+=========================+"+TEXT_RESET);
            System.out.println(TEXT_CYAN+"\t\t\t\t\t\t\t|      Choose Account     |"+TEXT_RESET);
            System.out.println(TEXT_PURPLE+"\t\t\t\t\t\t\t+=========================+"+TEXT_RESET);
            System.out.println(TEXT_CYAN+"\t\t\t\t\t\t\t|   1. Customer           |"+TEXT_RESET);
            System.out.println(TEXT_CYAN+"\t\t\t\t\t\t\t|   2. Seller             |"+TEXT_RESET);
            System.out.println(TEXT_CYAN+"\t\t\t\t\t\t\t|   3. Exit               |"+TEXT_RESET);
            System.out.println(TEXT_PURPLE+"\t\t\t\t\t\t\t+=========================+"+TEXT_RESET);
            System.out.print(TEXT_CYAN+"\t\t\t\t\t\t\t\t Choose: ");
            input = scanInt();
            if(input == 1){
                showAllCustomerAccount();
            }
            if(input == 2){
                showAllSellerAccount();
            }
        }while(input != 3);
    }

    void deleteAccount(){
        int input;
        do {
            System.out.println(TEXT_PURPLE+"\t\t\t\t\t\t\t+=========================+"+TEXT_RESET);
            System.out.println(TEXT_CYAN+"\t\t\t\t\t\t\t|      Choose Account     |"+TEXT_RESET);
            System.out.println(TEXT_PURPLE+"\t\t\t\t\t\t\t+=========================+"+TEXT_RESET);
            System.out.println(TEXT_CYAN+"\t\t\t\t\t\t\t|   1. Customer           |"+TEXT_RESET);
            System.out.println(TEXT_CYAN+"\t\t\t\t\t\t\t|   2. Seller             |"+TEXT_RESET);
            System.out.println(TEXT_CYAN+"\t\t\t\t\t\t\t|   3. Exit               |"+TEXT_RESET);
            System.out.println(TEXT_PURPLE+"\t\t\t\t\t\t\t+=========================+"+TEXT_RESET);
            System.out.print(TEXT_CYAN+"\t\t\t\t\t\t\t\t Choose: ");
            input = scanInt();
            if(input == 1){
                deleteAccountCustomer();
            }
            if(input == 2){
                deleteAccountSeller();
            }
        }while(input != 3);
    }

    void deleteAccountCustomer(){
        String deleted;
        if (loginCustomer.size() == 0){
            System.out.println(TEXT_RED+"\n\t\t\t\t\t\t\tThere's no new account yet!\n");
            System.out.println(TEXT_RED+"\t\t\t\t\t\t\t Press enter to continue...");
            scan.nextLine();
            return;
        }
        showAllCustomerAccount();
        do {
            System.out.println(TEXT_CYAN+"\t\t\t\t\t\tChoose Account to be deleted by their name\n");
            System.out.print(TEXT_CYAN+"\t\t\t\t\t\t\t\t Choose: ");
            deleted = scan.nextLine();
        }while(!loginCustomer.containsKey(deleted));
        loginCustomer.remove(deleted);
    }

    void deleteAccountSeller(){
        String deleted;
        if (loginSeller.size() == 0){
            System.out.println(TEXT_RED+"\n\t\t\t\t\t\t\tThere's no new account yet!\n");
            System.out.println(TEXT_RED+"\t\t\t\t\t\t\t Press enter to continue...");
            scan.nextLine();
            return;
        }
        showAllSellerAccount();
        do {
            System.out.println(TEXT_CYAN+"\t\t\t\t\t\tChoose Account to be deleted by their name\n");
            System.out.print(TEXT_CYAN+"\t\t\t\t\t\t\t\t Choose: ");
            deleted = scan.nextLine();
        } while (!loginSeller.containsKey(deleted));
        loginSeller.remove(deleted);
    }

    void clearAccount(){
        int input;
        do {
            System.out.println(TEXT_RED+"\t\t\t\t\t\t\t+=========================+"+TEXT_RESET);
            System.out.println(TEXT_CYAN+"\t\t\t\t\t\t\t|      Choose Account     |"+TEXT_RESET);
            System.out.println(TEXT_RED+"\t\t\t\t\t\t\t+=========================+"+TEXT_RESET);
            System.out.println(TEXT_CYAN+"\t\t\t\t\t\t\t|   1. Customer           |"+TEXT_RESET);
            System.out.println(TEXT_CYAN+"\t\t\t\t\t\t\t|   2. Seller             |"+TEXT_RESET);
            System.out.println(TEXT_CYAN+"\t\t\t\t\t\t\t|   3. Exit               |"+TEXT_RESET);
            System.out.println(TEXT_RED+"\t\t\t\t\t\t\t+=========================+"+TEXT_RESET);
            System.out.print(TEXT_CYAN+"\t\t\t\t\t\t\t\t Choose: ");
            input = scanInt();
            if(input == 1){
                if(loginCustomer.size() == 0 ){
                    System.out.println(TEXT_RED+"\n\t\t\t\t\t\t\tThere's no new account yet!\n");
                    System.out.println(TEXT_RED+"\t\t\t\t\t\t\t Press enter to continue...");
                    scan.nextLine();
                    return;
                }
                loginCustomer.clear();
                System.out.println(TEXT_CYAN+"\n\t\t\t\t\t\tAll of the customer accounts are deleted!\n");
                System.out.println(TEXT_CYAN+"\t\t\t\t\t\t\t Press enter to continue...");
                scan.nextLine();
            }
            if(input == 2) {
                if(loginSeller.size() == 0 ){
                    System.out.println(TEXT_RED+"\n\t\t\t\t\t\t\tThere's no new account yet!\n");
                    System.out.println(TEXT_RED+"\t\t\t\t\t\t\t Press enter to continue...");
                    scan.nextLine();
                    return;
                }
                loginSeller.clear();
                System.out.println(TEXT_CYAN+"\n\t\t\t\t\t\t  All of the seller accounts are deleted!\n");
                System.out.println(TEXT_CYAN+"\t\t\t\t\t\t\t Press enter to continue...");
                scan.nextLine();
            }
        }while(input != 3);
    }

    void showAllCustomerAccount(){
        if(loginCustomer.size() == 0 ){
            System.out.println(TEXT_RED+"\n\t\t\t\t\t\t\tThere's no new account yet!\n");
            System.out.println(TEXT_RED+"\t\t\t\t\t\t\t Press enter to continue...");
            scan.nextLine();
            return;
        }
        System.out.println(TEXT_PURPLE+"\n\t\t\t\t\t+============================================================+");
        System.out.println(TEXT_CYAN+"\t\t\t\t\t| No |      Name       |     Password     |   Date Created   |");
        System.out.println(TEXT_PURPLE+"\t\t\t\t\t+============================================================+");
        for(int i = 0; i < customersUsernames.size(); i++){
            System.out.printf(TEXT_CYAN+"\t\t\t\t\t| %2s | %-15s | %-16s | %-16s |\n", (i+1), customersUsernames.get(i), customerPasswords.get(i), datesCus.get(i));
        }
        System.out.println(TEXT_PURPLE+"\t\t\t\t\t+============================================================+\n");
        System.out.println(TEXT_CYAN+"\t\t\t\t\t\t\t Press enter to continue...");
        scan.nextLine();
    }

    void showAllSellerAccount(){
        if(loginSeller.size() == 0 ){
            System.out.println(TEXT_RED+"\n\t\t\t\t\t\t\tThere's no new account yet!\n");
            System.out.println(TEXT_RED+"\t\t\t\t\t\t\t Press enter to continue...");
            scan.nextLine();
            return;
        }
        System.out.println(TEXT_PURPLE+"\n\t\t\t\t\t+============================================================+");
        System.out.println(TEXT_CYAN+"\t\t\t\t\t| No |      Name       |     Password     |   Date Created   |");
        System.out.println(TEXT_PURPLE+"\t\t\t\t\t+============================================================+");
        for(int i = 0; i < sellerUsernames.size(); i++){
            System.out.printf(TEXT_CYAN+"\t\t\t\t\t| %2s | %-15s | %-16s | %-16s |\n", (i+1), sellerUsernames.get(i), sellerPasswords.get(i), datesSel.get(i));
        }
        System.out.println(TEXT_PURPLE+"\t\t\t\t\t+============================================================+\n");
        System.out.println(TEXT_CYAN+"\t\t\t\t\t\t\t Press enter to continue...");
        scan.nextLine();
    }

    void printMenuAdmin(){
        System.out.println(TEXT_PURPLE+"\t\t\t\t\t\t\t+=========================+"+TEXT_RESET);
        System.out.println(TEXT_CYAN+"\t\t\t\t\t\t\t|        Admin Menu       |"+TEXT_RESET);
        System.out.println(TEXT_PURPLE+"\t\t\t\t\t\t\t+=========================+"+TEXT_RESET);
        System.out.println(TEXT_CYAN+"\t\t\t\t\t\t\t|   1. Show Account       |"+TEXT_RESET);
        System.out.println(TEXT_CYAN+"\t\t\t\t\t\t\t|   2. Delete Account     |"+TEXT_RESET);
        System.out.println(TEXT_CYAN+"\t\t\t\t\t\t\t|   3. Clear Account      |"+TEXT_RESET);
        System.out.println(TEXT_CYAN+"\t\t\t\t\t\t\t|   4. Exit               |"+TEXT_RESET);
        System.out.println(TEXT_PURPLE+"\t\t\t\t\t\t\t+=========================+"+TEXT_RESET);
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