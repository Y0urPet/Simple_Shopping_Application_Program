import java.util.Scanner;

public class Seller implements ItemList{

    Scanner scan;
    final String TEXT_RED = "\u001B[31m";
    final String TEXT_GREEN = "\u001B[32m";
    final String TEXT_CYAN = "\u001B[36m";

    Seller(){
        scan = new Scanner(System.in);
    }

    void seller(){
        int input;
        do {
            printMenuSeller();
            System.out.print(TEXT_GREEN+"\t\t\t\t\t\t\t\t Choose: ");
            input = scanInt();
            if(input == 1){
                insertItem();
            }
            if(input == 2){
                showItemList();
            }
            if(input == 3){
                deleteItem();
            }
        }while(input != 4);
    }

    void insertItem(){
        String name;
        int price;
        do {
            System.out.print(TEXT_GREEN+"Input Item name [6-20 character]: ");
            name = scan.nextLine();
        }while(name.length() < 6 || name.length() > 20);
        do {
            System.out.print(TEXT_GREEN+"Input Item price [10000 - 100000]: ");
            price = scanInt();
        }while(price < 10000 || price > 100000);
        names.add(name);
        prices.add(price);

        System.out.println(TEXT_CYAN+"\n\t\t\t\t\t\t   Your item has successfully inserted!\n	");
        System.out.println(TEXT_CYAN+"\t\t\t\t\t\t\t Press enter to continue...");
        scan.nextLine();
    }

    void showItemList(){
        if (names.size() == 0){
            System.out.println(TEXT_RED+"\n\t\t\t\t\t\t\t   There's no item yet!\n");
            System.out.println(TEXT_RED+"\t\t\t\t\t\t\t Press enter to continue...");
            scan.nextLine();
            return;
        }
        sortProduct();
        System.out.println(TEXT_CYAN+"\n\t\t\t\t\t     +==============================================+");
        System.out.printf(TEXT_GREEN+"\t\t\t\t\t     %s %s %s %-11s %9s %-9s %9s\n", "|", "No", "|", "Name", "|", "Price", "|");
        System.out.println(TEXT_CYAN+"\t\t\t\t\t     +==============================================+");
        for(int i = 0; i < names.size(); i++){
            System.out.printf(TEXT_GREEN+"\t\t\t\t\t     %s %s %2s %-11s %9s %-9s %9s\n", "|", (i+1), "|", names.get(i), "|", prices.get(i), "|");
        }
        System.out.println(TEXT_CYAN+"\t\t\t\t\t     +==============================================+\n");
        System.out.println(TEXT_GREEN+"\t\t\t\t\t\t\t Press enter to continue...");
        scan.nextLine();
    }

    void deleteItem(){
        int deleted;
        if (names.size() == 0){
            System.out.println(TEXT_RED+"\n\t\t\t\t\t\t\t   There's no item yet!\n");
            System.out.println(TEXT_RED+"\t\t\t\t\t\t\t Press enter to continue...");
            scan.nextLine();
            return;
        }
        showItemList();
        do {
            System.out.println(TEXT_GREEN+"\n\t\t\t\t\t\tChoose item to be deleted by their number");
            System.out.print(TEXT_GREEN+"\t\t\t\t\t\t\t\t Choose: ");
            deleted = scanInt();
        }while(deleted<0 || deleted> names.size());
        deleted -= 1;
        names.remove(deleted);
        prices.remove(deleted);

        System.out.println(TEXT_CYAN+"\n\t\t\t\t\t\t      Item has successfully deleted!\n");
        System.out.println(TEXT_CYAN+"\t\t\t\t\t\t\t Press enter to continue...");
        scan.nextLine();
    }

    void printMenuSeller(){
        System.out.println(TEXT_CYAN+"\t\t\t\t\t\t\t+=========================+");
        System.out.println(TEXT_GREEN+"\t\t\t\t\t\t\t|       Seller Menu       |");
        System.out.println(TEXT_CYAN+"\t\t\t\t\t\t\t+=========================+");
        System.out.println(TEXT_GREEN+"\t\t\t\t\t\t\t|   1. Insert Item        |");
        System.out.println(TEXT_GREEN+"\t\t\t\t\t\t\t|   2. Current Item List  |");
        System.out.println(TEXT_GREEN+"\t\t\t\t\t\t\t|   3. Delete Item        |");
        System.out.println(TEXT_GREEN+"\t\t\t\t\t\t\t|   4. Log Out            |");
        System.out.println(TEXT_CYAN+"\t\t\t\t\t\t\t+=========================+");

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

    void sortProduct() {
        for (int i = 0; i < names.size() ; i++) {
            for (int j = i+1; j < names.size() ; j++) {
                if(prices.get(i) > prices.get(j)) {
                    String nameTemp = names.get(i);
                    int priceTemp = prices.get(i);

                    names.set(i, names.get(j));
                    prices.set(i, prices.get(j));

                    names.set(j, nameTemp);
                    prices.set(j, priceTemp);
                }

            }
        }
    }
}