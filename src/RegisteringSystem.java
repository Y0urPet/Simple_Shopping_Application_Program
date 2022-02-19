import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class RegisteringSystem implements AccountList{
    Random rand;
    Scanner scan;
    final String TEXT_GREEN = "\u001B[32m";
    final String TEXT_BLUE = "\u001B[34m";
    final String TEXT_PURPLE = "\u001B[35m";

    public RegisteringSystem(){
        scan = new Scanner(System.in);
        rand = new Random();
    }

    void regist(){
        int option;
        String name;
        String pass;
        LocalDate hari;
        System.out.println(TEXT_BLUE+"\t\t\t\t\t\t\t+=========================+");
        System.out.println(TEXT_GREEN+"\t\t\t\t\t\t\t|       Register As       |");
        System.out.println(TEXT_BLUE+"\t\t\t\t\t\t\t+=========================+");
        System.out.println(TEXT_GREEN+"\t\t\t\t\t\t\t|   1. Customer           |");
        System.out.println(TEXT_GREEN+"\t\t\t\t\t\t\t|   2. Seller             |");
        System.out.println(TEXT_GREEN+"\t\t\t\t\t\t\t|   3. Exit               |");
        System.out.println(TEXT_BLUE+"\t\t\t\t\t\t\t+=========================+");

        do{
            System.out.print(TEXT_GREEN+"\t\t\t\t\t\t\t\t Choose: ");
            option = scanInt();

        }while(option <1 || option >3);
        if(option == 3){
            return;
        }
        do {
            System.out.print(TEXT_GREEN+"Input account name [6-20 character]: ");
            name = scan.nextLine();
        }while(name.length() < 6 || name.length() > 20);
        String rand_int1 = getRand();
        String rand_int2 = getRand();
        String rand_int3 = getRand();
        String rand_int4 = getRand();
        String rand_int5 = getRand();
        String rand_int6 = getRand();
        String generatedPassword = rand_int1 + rand_int2 + rand_int3 + rand_int4 + rand_int5 + rand_int6;

        System.out.println(TEXT_PURPLE+"Password recommendation: " + generatedPassword);
        do {
            System.out.print(TEXT_GREEN+"Input account password [6-20 character]: ");
            pass = scan.nextLine();
        }while(pass.length() < 6 || pass.length() > 20);
        hari = LocalDate.now();
        if (option == 1){
            loginCustomer.put(name,pass);
            customersUsernames.add(name);
            customerPasswords.add(pass);
            datesCus.add(hari);
        }
        if (option == 2){
            loginSeller.put(name,pass);
            sellerUsernames.add(name);
            sellerPasswords.add(pass);
            datesSel.add(hari);
        }

        System.out.println(TEXT_BLUE+"\n\t\t\t\t\t\t  Your Account has successfully created!\n");
        System.out.println(TEXT_BLUE+"\t\t\t\t\t\t\t Press enter to continue...");
        scan.nextLine();
    }

    public String getRand(){
        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","1","2","3","4","5","6","7","8","9","0"};
        return alphabet[rand.nextInt(alphabet.length)];
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