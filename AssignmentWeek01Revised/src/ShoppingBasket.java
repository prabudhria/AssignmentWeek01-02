import java.util.ArrayList;

public class ShoppingBasket {


    public ArrayList<Goods> CreateBasket(String[] shopping_basket){
        ArrayList<Goods> goods = new ArrayList<Goods>();
        Utility utility = new Utility();

        //creating good object for every good specification in shopping basket
        for (String good_specification : shopping_basket) goods.add(CreateGood(utility, good_specification));

        return goods;
    }

    public Goods CreateGood(Utility utility, String good_specification){
        String name;
        Kind kind;
        float rate;
        int quantity;
        boolean imported;
        float sales_tax;
        imported = utility.ExtractGoodImport(good_specification); //extracting the import status of good
        name = utility.ExtractGoodName(good_specification, imported); //extracting name of the good
        quantity = utility.ExtractGoodQuantity(good_specification); //extracting quantity of the good
        rate = utility.ExtractGoodRate(good_specification); //extracting rate of the good
        kind = utility.ExtractGoodType(good_specification); //extracting kind of good (normal of exemption)
        Goods good = new Goods(name, kind, rate, quantity, imported);
        sales_tax = utility.SalesTaxCalculator(quantity, rate, imported, kind); //calculating the tax applicable on the good
        good.setSales_tax(sales_tax);
        good.setRate(rate+sales_tax);  //updating the rate of the good after adding the taxes
        return good;
    }

}
