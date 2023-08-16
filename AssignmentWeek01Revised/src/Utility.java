public class Utility {
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
        sales_tax = Float.parseFloat(String.format("%.2f", sales_tax));
//        sales_tax *= quantity;
        good.setRate(rate+sales_tax);
        good.setSales_tax(sales_tax*quantity);
    }
}