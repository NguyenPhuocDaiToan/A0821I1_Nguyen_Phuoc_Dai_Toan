package model;

public class GenuineProduct extends Product{
    private String nation;
    private String status;
    public GenuineProduct() {

    }
    public GenuineProduct(int id, String name, String manufacturer, int price, String nation, String status) {
        super(id, name, manufacturer, price);
        this.nation = nation;
        this.status = status;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString() +
                "," + nation +
                "," + status;
    }
}
