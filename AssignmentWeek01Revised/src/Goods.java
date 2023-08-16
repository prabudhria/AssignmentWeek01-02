public class Goods {
    private String name;
    private Kind kind;
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

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public Goods(String name, Kind kind, float rate, int quantity, boolean imported) {
        this.name = name;
        this.kind = kind;
        this.rate = rate;
        this.quantity = quantity;
        this.imported = imported;
    }
}
