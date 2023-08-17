public class Utility {
    public String ExtractGoodName(String str, boolean isimported) {
        String goodname = isimported?str.substring(str.indexOf("import")+9, str.indexOf(" at ")):
                str.substring(str.indexOf(" ")+1, str.indexOf(" at "));
        return goodname;
    }

    public float ExtractGoodRate(String str) {
        String ratestring = str.substring(str.indexOf(" at ")+4, str.indexOf("kind")-1);
        return Float.parseFloat(ratestring);
    }

    public int ExtractGoodQuantity(String str) {
        String quantitystring = str.substring(0, str.indexOf(" "));
        return Integer.parseInt(quantitystring);
    }


    public Kind ExtractGoodType(String str) {
        String type = str.substring(str.indexOf("=")+1);
        if(type.equals("normal")) return Kind.normal;
        else return Kind.exemption;
    }

    public boolean ExtractGoodImport(String str) {
        return str.contains("imported");
    }

    public float SalesTaxCalculator(int quantity, float rate, boolean imported, Kind kind) {
        float sales_tax=0;

        if(imported) sales_tax += (float) (rate*0.05); //adding 5% interest in case of imported good
        if(kind == Kind.normal) sales_tax += (float) (rate*0.1); //adding 10 percent interest in case of normal good


        sales_tax = Math.round( sales_tax * 20.0) / (float)20.0; //rounding off to nearest 0.05 amount
        sales_tax *= quantity;


        return sales_tax;
    }
}
