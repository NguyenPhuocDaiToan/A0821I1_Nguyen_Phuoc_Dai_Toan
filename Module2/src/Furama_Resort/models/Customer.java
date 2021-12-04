package Furama_Resort.models;

import Furama_Resort.utils.ConstantUtil.*;

public class Customer extends Person {
    private TypeCustomer typeCustomer;

    public Customer(int id, String code, String fullName, String birthday, Gender gender, String phone, String email, String address) {
        super(id, code, fullName, birthday, gender, phone, email, address);
    }

    public TypeCustomer getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(TypeCustomer typeCustomer) {
        this.typeCustomer = typeCustomer;
    }
}
