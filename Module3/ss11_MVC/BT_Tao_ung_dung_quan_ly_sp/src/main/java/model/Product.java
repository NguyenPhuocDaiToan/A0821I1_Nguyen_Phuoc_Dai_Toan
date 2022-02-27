package model;

public class Product {
    private int id;
    private String name;
    private double price;
    private String desc;
    private String manufacture;

    public Product() {

    }

    public Product(int id, String name, double price, String desc, String manufacture) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.desc = desc;
        this.manufacture = manufacture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }
}
