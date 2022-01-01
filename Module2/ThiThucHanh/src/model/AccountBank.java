package model;

public abstract class AccountBank {
    private int id;
    private String account;
    private String name;
    private String dateCreat;

    public AccountBank(int id, String account, String name, String dateCreat) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.dateCreat = dateCreat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateCreat() {
        return dateCreat;
    }

    public void setDateCreat(String dateCreat) {
        this.dateCreat = dateCreat;
    }

    public String toString() {
        return id + "," + account + "," + name + "," + dateCreat;
    }
}

