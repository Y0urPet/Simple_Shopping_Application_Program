import java.util.Scanner;

public class Main {
    Scanner scan;
    LoginSystem login;
    RegisteringSystem regist;
    Admin admin;
    final String TEXT_RESET = "\u001B[0m";
    final String TEXT_GREEN = "\u001B[32m";
    final String TEXT_YELLOW = "\u001B[33m";

    Main(){
        scan = new Scanner(System.in);
        login = new LoginSystem();
        regist = new RegisteringSystem();
        admin = new Admin();
    }

    void run(){
        int input;
        do {
            printMenu();
            input = scanInt();
            if(input == 1){
                login.login();
            }
            if(input == 2){
                regist.regist();
            }
            if(input == 3){
                admin.admin();
            }
        }while(input != 4);
    }

    void printMenu(){
        System.out.println(TEXT_YELLOW+"  _______________    ____     ________________________        ______________      _____      _____     _________________     _______________"+TEXT_RESET);
        System.out.println(TEXT_YELLOW+" /____     _____/\\  /___/\\   /   ______    ______    /\\      /   __________/\\    /    /     /    /\\   /   _________    /\\   /   ________   /\\"+TEXT_RESET);
        System.out.println(TEXT_YELLOW+" \\___/    / ____\\/  \\___\\/  /   / ____/   / ____/   / /     /   /\\_________\\/   /    /     /    / /  /   /\\_______/   / /  /   /_______/  / /"+TEXT_RESET);
        System.out.println(TEXT_YELLOW+"    /    / /      ____     /   / /   /   / /   /   / /     /   /_/________     /    /_____/    / /  /   / /      /   / /  /   /_______/  / /"+TEXT_RESET);
        System.out.println(TEXT_YELLOW+"   /    / /      /   /\\   /   / /   /   / /   /   / /     /__________    /\\   /    /_____     / /  /   / /      /   / /  /    __________/ /"+TEXT_RESET);
        System.out.println(TEXT_GREEN+"  /    / /      /   / /  /   / /   /   / /   /   / /      \\_________/   / /  /    /\\____/    / /  /   / /      /   / /  /   /\\__________\\/"+TEXT_RESET);
        System.out.println(TEXT_GREEN+" /    / /      /   / /  /   / /   /   / /   /   / /      __________/   / /  /    / /   /    / /  /   /_/______/   / /  /   / /"+TEXT_RESET);
        System.out.println(TEXT_GREEN+"/____/ /      /___/ /  /___/ /   /___/ /   /___/ /      /_____________/ /  /____/ /   /____/ /  /________________/ /  /___/ /"+TEXT_RESET);
        System.out.println(TEXT_GREEN+"\\____\\/       \\___\\/   \\___\\/    \\___\\/    \\___\\/       \\_____________\\/   \\____\\/    \\____\\/   \\________________\\/   \\___\\/"+TEXT_RESET);
        System.out.println(TEXT_YELLOW+"\t\t\t\t\t\t\t+=========================+"+TEXT_RESET);
        System.out.println(TEXT_GREEN+"\t\t\t\t\t\t\t|           Menu          |"+TEXT_RESET);
        System.out.println(TEXT_YELLOW+"\t\t\t\t\t\t\t+=========================+"+TEXT_RESET);
        System.out.println(TEXT_GREEN+"\t\t\t\t\t\t\t|   1. Login              |"+TEXT_RESET);
        System.out.println(TEXT_GREEN+"\t\t\t\t\t\t\t|   2. Register           |"+TEXT_RESET);
        System.out.println(TEXT_GREEN+"\t\t\t\t\t\t\t|   3. Admin              |"+TEXT_RESET);
        System.out.println(TEXT_GREEN+"\t\t\t\t\t\t\t|   4. Exit               |"+TEXT_RESET);
        System.out.println(TEXT_YELLOW+"\t\t\t\t\t\t\t+=========================+"+TEXT_RESET);
        System.out.print(TEXT_GREEN+"\t\t\t\t\t\t\t\t Choose: ");
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

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}
