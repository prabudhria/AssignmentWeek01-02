public class Goods {
    private String name;
    private String type;
    private float rate;
    private int quantity;
    private boolean imported;
    private float sales_tax;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    public float getSales_tax() {
        return sales_tax;
    }

    public void setSales_tax(float sales_tax) {
        this.sales_tax = sales_tax;
    }

    public Goods(String name, String type, float rate, int quantity, boolean imported, float sales_tax) {
        this.name = name;
        this.type = type;
        this.rate = rate;
        this.quantity = quantity;
        this.imported = imported;
        this.sales_tax = sales_tax;
    }
}
