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

        ShoppingBasket obj = new ShoppingBasket();
        ArrayList<Goods> goods = new ArrayList<Goods>();
        goods = obj.create_good(shopping_basket);
        float total=0, sales_tax=0;

        for(int i=0; i<size; i++){
            Goods good = goods.get(i);
            System.out.println(good.getQuantity() + " " + good.getName() + " :" + String.format("%.2f", good.getRate()));
            total += good.getRate();
            sales_tax += good.getSales_tax();
        }

        System.out.println("Sales Taxes:" + sales_tax);
        System.out.println("Total:" + String.format("%.2f", total));
    }
}
