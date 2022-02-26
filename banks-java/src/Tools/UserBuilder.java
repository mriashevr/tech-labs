package Tools;

import Entities.BankAccount;
import Entities.User;

import java.util.ArrayList;

public class UserBuilder {
    private String _name;
    private String _surname;
    private String _address;
    private Integer _passport;
    private ArrayList<BankAccount> _listAccounts;

    public UserBuilder addName(String name) {
        _name = name;
        return this;
    }

    public UserBuilder addSurname(String surname) {
        _surname = surname;
        return this;
    }

    public UserBuilder addAddress(String address) {
        _address = address;
        return this;
    }

    public UserBuilder addPassport(int passport) {
        _passport = passport;
        return this;
    }

    public UserBuilder addListAccounts(ArrayList<BankAccount> bankAccounts) {
        _listAccounts = bankAccounts;
        return this;
    }

    public User Build() {
        User finalUser = new User(_name, _surname, _address, _passport);
        return finalUser;
    }
}
