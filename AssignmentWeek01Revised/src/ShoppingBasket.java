import java.util.ArrayList;

public class ShoppingBasket {
    public ArrayList<Goods> create_good(String[] shopping_basket){
        int size = shopping_basket.length;
        ArrayList<Goods> goods = new ArrayList<Goods>();

        for(int i=0; i<size; i++) {
             String name;
             Kind kind;
             float rate;
             int quantity;
             boolean imported;
             float sales_tax=0;
            ShoppingBasket obj = new ShoppingBasket();
            imported = obj.extractGoodImport(shopping_basket[i]);
            name = obj.extractGoodName(shopping_basket[i], imported);
            quantity = obj.extractGoodQuantity(shopping_basket[i]);
            rate = obj.extractGoodRate(shopping_basket[i]);
            kind = obj.extractGoodType(shopping_basket[i]);
            Goods good = new Goods(name, kind, rate, quantity, imported, sales_tax);
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
        String ratestring = str.substring(str.indexOf(" at ")+4, str.indexOf("kind")-1);
        return Float.parseFloat(ratestring);
    }

    public int extractGoodQuantity(String str) {
        String quantitystring = str.substring(0, str.indexOf(" "));
        return Integer.parseInt(quantitystring);

    }

    public Kind extractGoodType(String str) {
        String type = str.substring(str.indexOf("=")+1);
        if(type.equals("normal")) return Kind.normal;
        else return Kind.exemption;
    }

    public boolean extractGoodImport(String str) {
        return str.contains("imported");
    }

    public void salesTaxCalculator(Goods good) {
        float sales_tax=0;
        int quantity = good.getQuantity();
        float rate = good.getRate();
        boolean imported = good.isImported();
        Kind kind = good.getKind();

        if(imported) sales_tax += (float) (rate*0.05);
        switch (kind){
            case normal:  sales_tax += (float) (rate*0.1);
            break;
            default: break;
        }
//        if(!type.equals("book") && !type.equals("food") && !type.equals("medical product")) sales_tax += (float) (rate*0.1);

        sales_tax = Math.round( sales_tax * 20.0) / (float)20.0;
        good.setRate(rate+sales_tax);

        good.setSales_tax(sales_tax*quantity);
    }

}
