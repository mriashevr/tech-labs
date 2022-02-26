package tools;

import entities.BankAccount;
import entities.User;

import java.util.ArrayList;

public class UserBuilder {
    private String name;
    private String surname;
    private String address;
    private Integer passport;
    private ArrayList<BankAccount> _listAccounts;

    public UserBuilder addName(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder addSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public UserBuilder addAddress(String address) {
        this.address = address;
        return this;
    }

    public UserBuilder addPassport(int passport) {
        this.passport = passport;
        return this;
    }

    public UserBuilder addListAccounts(ArrayList<BankAccount> bankAccounts) {
        _listAccounts = bankAccounts;
        return this;
    }

    public User Build() {
        User finalUser = new User(name, surname, address, passport);
        return finalUser;
    }
}
