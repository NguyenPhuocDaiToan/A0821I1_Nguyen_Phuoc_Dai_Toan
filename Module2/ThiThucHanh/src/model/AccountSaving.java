package model;

public class AccountSaving extends AccountBank {
    private double amount_of_savings;
    private String dateSaving;
    private float interest_rate;
    private int month;

    public AccountSaving(int id, String account, String name, String dateCreat, double amount_of_savings, String dateSaving, float interest_rate, int month) {
        super(id, account, name, dateCreat);
        this.amount_of_savings = amount_of_savings;
        this.dateSaving = dateSaving;
        this.interest_rate = interest_rate;
        this.month = month;
    }

    public double getAmount_of_savings() {
        return amount_of_savings;
    }

    public String getDateSaving() {
        return dateSaving;
    }

    public float getInterest_rate() {
        return interest_rate;
    }

    public int getMonth() {
        return month;
    }

    public String toString() {
        return super.toString() + "," + amount_of_savings + "," + dateSaving + "," + interest_rate + "," + month;
    }
}
