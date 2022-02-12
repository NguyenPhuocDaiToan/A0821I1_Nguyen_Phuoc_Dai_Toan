public class Customer {
    private String name;
    private String date;
    private String address;
    private String srcImg;

    public Customer(String name, String date, String address, String srcImg) {
        this.name = name;
        this.date = date;
        this.address = address;
        this.srcImg = srcImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSrcImg() {
        return srcImg;
    }

    public void setSrcImg(String srcImg) {
        this.srcImg = srcImg;
    }
}

