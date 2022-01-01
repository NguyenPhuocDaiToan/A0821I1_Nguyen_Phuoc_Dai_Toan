package model;

public class AccountPayment extends AccountBank {
    private String card;
    private double ammount;

    public AccountPayment(int id, String account, String name, String dateCreat, String card, double ammount) {
        super(id, account, name, dateCreat);
        this.card = card;
        this.ammount = ammount;
    }

    public String getCard() {
        return card;
    }

    public double getAmmount() {
        return ammount;
    }

    public String toString() {
        return super.toString() + "," + card + "," + ammount;
    }
}
