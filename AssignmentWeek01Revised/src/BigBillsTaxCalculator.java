import java.security.Principal;
import java.util.ArrayList;
import java.util.Scanner;

public class BigBillsTaxCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many goods?");
        int size = sc.nextInt(); sc.nextLine();

        String[] shopping_basket = new String[size];

        for(int i=0; i<size; i++){
            shopping_basket[i] = sc.nextLine();
            System.out.println("What is the kind?");
            shopping_basket[i] += " kind=";
            shopping_basket[i] += sc.nextLine();
        }

        BigBillsTaxCalculator bigBillsTaxCalculator = new BigBillsTaxCalculator();
        bigBillsTaxCalculator.PrintReceiptDetails(shopping_basket);
    }

    public void PrintReceiptDetails(String[] shopping_basket){
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        ArrayList<Goods> goods = shoppingBasket.CreateBasket(shopping_basket);
        float total=0, sales_tax=0;

        //printing updated rates of goods after tax
        for(Goods good : goods){
            System.out.println(good.getQuantity() + " " + good.getName() + " :" + String.format("%.2f", good.getRate()));
            total += good.getRate();
            sales_tax += good.getSales_tax();
        }

        //printing total tax and total bill
        System.out.println("Sales Taxes:" + sales_tax);
        System.out.println("Total:" + String.format("%.2f", total));
    }
}
