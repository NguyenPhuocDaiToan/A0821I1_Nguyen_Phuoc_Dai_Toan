package model;

public class HandedProduct extends Product{
    private String warranty_period;
    public HandedProduct() {

    }

    public HandedProduct(int id, String name, String manufacturer, int price, String warranty_period) {
        super(id, name, manufacturer, price);
        this.warranty_period = warranty_period;
    }


    public String getWarranty_period() {
        return warranty_period;
    }

    public void setWarranty_period(String warranty_period) {
        this.warranty_period = warranty_period;
    }

    @Override
    public String toString() {
        return super.toString() +
                "," + warranty_period;
    }
}
