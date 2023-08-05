import java.util.ArrayList;

public class ShoppingBasket {
    public ArrayList<Goods> create_good(String[] shopping_basket){
        int size = shopping_basket.length;
        ArrayList<Goods> goods = new ArrayList<Goods>();

        for(int i=0; i<size; i++) {
             String name;
             String type;
             float rate;
             int quantity;
             boolean imported;
             float sales_tax=0;
            ShoppingBasket obj = new ShoppingBasket();
            imported = obj.extractGoodImport(shopping_basket[i]);
            name = obj.extractGoodName(shopping_basket[i], imported);
            quantity = obj.extractGoodQuantity(shopping_basket[i]);
            rate = obj.extractGoodRate(shopping_basket[i]);
            type = obj.extractGoodType(shopping_basket[i]);
            Goods good = new Goods(name, type, rate, quantity, imported, sales_tax);
            obj.salesTaxCalculator(good);
            goods.add(good);
        }
        return goods;
    }

    public String extractGoodName(String str, boolean isimported) {
        String goodname = isimported?str.substring(str.indexOf("import")+9, str.indexOf(" at ")):str.substring(str.indexOf(" ")+1, str.indexOf(" at "));
        return goodname;
    }

    public float extractGoodRate(String str) {
        String ratestring = str.substring(str.indexOf(" at ")+4, str.indexOf("type")-1);
        return Float.parseFloat(ratestring);
    }

    public int extractGoodQuantity(String str) {
        String quantitystring = str.substring(0, str.indexOf(" "));
        return Integer.parseInt(quantitystring);

    }

    public String extractGoodType(String str) {
        return str.substring(str.indexOf("=")+1);
    }

    public boolean extractGoodImport(String str) {
        return str.contains("imported");
    }

    public void salesTaxCalculator(Goods good) {
        float sales_tax=0;
        int quantity = good.getQuantity();
        float rate = good.getRate();
        boolean imported = good.isImported();
        String type = good.getType();

        if(imported) sales_tax += (float) (rate*0.05);
        if(!type.equals("book") && !type.equals("food") && !type.equals("medical product")) sales_tax += (float) (rate*0.1);

        sales_tax = Math.round( sales_tax * 20.0) / (float)20.0;
        good.setRate(rate+sales_tax);

        good.setSales_tax(sales_tax*quantity);
    }

}
