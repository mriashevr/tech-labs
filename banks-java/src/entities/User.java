package entities;

import tools.UserBuilder;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String name;
    private final String surname;
    private final List<Bank> banks;
    private String address;
    private Integer passport;

    public User(String name, String surname, String address, Integer passport) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.passport = passport;
        banks = new ArrayList<>();
    }

    public UserBuilder toBuilder(UserBuilder clientBuilder) {
        clientBuilder.addName(name);
        clientBuilder.addSurname(surname);
        clientBuilder.addAddress(address);
        clientBuilder.addPassport(passport);
        return clientBuilder;
    }

    public String setAddress(String address) {
        this.address = address;
        return this.address;
    }

    public Integer setPassport(Integer passport) {
        this.passport = passport;
        return this.passport;
    }

    public String getFirstName() {
        return name;
    }

    public String GetLastName() {
        return surname;
    }

    public String GetAddress() {
        return address;
    }

    public int GetPassport() {
        return passport;
    }

    public List<Bank> GetBank() {
        return banks;
    }

    public List<Bank> addListBank(Bank bank) {
        banks.add(bank);
        return banks;
    }

    public Boolean validation() {
        if (passport == null || address == null) {
            return false;
        }

        return true;
    }
}
