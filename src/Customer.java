import java.util.Scanner;

public class Customer implements ItemList{

    Scanner scan;
    final String TEXT_RESET = "\u001B[0m";
    final String TEXT_RED = "\u001B[31m";
    final String TEXT_BLUE = "\u001B[34m";
    final String TEXT_CYAN = "\u001B[36m";

    Customer(){
        scan = new Scanner(System.in);
    }

    void customer(){
        int option, order, total = 0, pay, change, pay1 = 0, bill;
        String answer;
        if (names.size() == 0){
            System.out.println(TEXT_RED+"\n\t\t\t\t\t\tThere's no item yet! Please Try Again Later.\n"+TEXT_RESET);
            System.out.println(TEXT_RED+"\t\t\t\t\t\t\t Press enter to continue..."+TEXT_RESET);
            scan.nextLine();
            return;
        }
        printMenuCustomer();
        do{
            System.out.print(TEXT_BLUE+"\t\t\t\t\t\t\t\t Choose: ");
            option = scanInt();
        }while(option < 1 || option > 2);
        if (option == 1){
            do{
                do{
                    System.out.print(TEXT_BLUE+"Choose Item Number: ");
                    order = scanInt();
                }while(order < 1 || order > names.size());
                order-=1;
                total += prices.get(order);
                pilihans.add(names.get(order));
                System.out.print(TEXT_RED+"Do you want to add another item[y/n]? ");
                answer = scan.nextLine();
            }while(answer.equals("y"));

            System.out.println();
            System.out.println(TEXT_CYAN+"\t\t\t\t\t     ------------------------------------------------");
            System.out.println(TEXT_BLUE+"\t\t\t\t\t                  List of Selected Item              ");
            System.out.println(TEXT_CYAN+"\t\t\t\t\t     ------------------------------------------------");
            for(int i = 0; i < pilihans.size();i++){
                System.out.println(TEXT_BLUE+"\t\t\t\t\t      " + (i+1) + ". "+ pilihans.get(i));
            }
            System.out.println(TEXT_CYAN+"\t\t\t\t\t     ------------------------------------------------");
            System.out.println(TEXT_BLUE+"\t\t\t\t\t      Total amount: Rp " + total);
            do{
                System.out.print(TEXT_BLUE+"\t\t\t\t\t      Enter payment amount [0 to cancel]: Rp ");
                pay = scanInt();
                pay1 += pay;
                if (pay == 0){
                    pilihans.clear();
                    return;
                }
                if (pay1 < total){
                    bill = total - pay1;
                    System.out.println(TEXT_RED+"\n\t\t\t\t\tPayment amount must be over or the same as the total amount!\n"+TEXT_RESET);
                    System.out.println("\t\t\t\t\t      Outstanding Bill: Rp " + bill);
                }
            } while (pay1 < total);
            change = pay1 - total;
            System.out.println(TEXT_BLUE+"\t\t\t\t\t      Change: Rp " + change);
            System.out.println(TEXT_CYAN+"\t\t\t\t\t     ------------------------------------------------");
            System.out.println(TEXT_RED+"\n\t\t\t\t\t\t\t Press enter to continue..."+TEXT_RESET);
            scan.nextLine();
        }
    }

    void printMenuCustomer(){
        showItemList();

        System.out.println(TEXT_BLUE+"\t\t\t\t\t     |                 1. Buy Item                  |"+TEXT_RESET);
        System.out.println(TEXT_BLUE+"\t\t\t\t\t     |                 2. Log Out                   |");
        System.out.println(TEXT_CYAN+"\t\t\t\t\t     +==============================================+"+TEXT_RESET);
    }

    void showItemList(){
        if (names.size() == 0){
            System.out.println(TEXT_RED+"\n\t\t\t\t\t\tThere's no item yet! Please Try Again Later.\n");
            return;
        }
        sortProduct();
        System.out.println(TEXT_CYAN+"\n\t\t\t\t\t     +==============================================+");
        System.out.println(TEXT_BLUE+"  \t\t\t\t\t     | No |       Name         |        Price       |");
        System.out.println(TEXT_CYAN+"  \t\t\t\t\t     +==============================================+");
        for(int i = 0; i < names.size(); i++){
            System.out.printf(TEXT_BLUE+"  \t\t\t\t\t     | %2s | %-19s | %-17s |\n", (i+1), names.get(i), prices.get(i));
        }
        System.out.println(TEXT_CYAN+"\t\t\t\t\t     +==============================================+");
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