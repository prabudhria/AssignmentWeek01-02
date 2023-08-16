import java.util.ArrayList;

public class ShoppingBasket {


    public ArrayList<Goods> CreateBasket(String[] shopping_basket){
        ArrayList<Goods> goods = new ArrayList<Goods>();

        for (String good_specification : shopping_basket) goods.add(CreateGood(good_specification)); //creating good object for every good specification in shopping basket

        return goods;
    }

    public Goods CreateGood(String good_specification){
        String name;
        Kind kind;
        float rate;
        int quantity;
        boolean imported;
        float sales_tax=0;
        Utility utility = new Utility();
        imported = utility.extractGoodImport(good_specification);
        name = utility.extractGoodName(good_specification, imported);
        quantity = utility.extractGoodQuantity(good_specification);
        rate = utility.extractGoodRate(good_specification);
        kind = utility.extractGoodType(good_specification);
        Goods good = new Goods(name, kind, rate, quantity, imported, sales_tax);
        utility.salesTaxCalculator(good);
        return good;
    }

}
