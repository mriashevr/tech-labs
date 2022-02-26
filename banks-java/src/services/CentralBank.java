package services;

import entities.Bank;
import entities.BankAccount;
import entities.User;
import tools.UserBuilder;

import java.time.LocalDate;
import java.util.ArrayList;

public class CentralBank {
    private ArrayList<Bank> _banks = new ArrayList<Bank>();

    public User createUser(String name, String surname, Bank bank) {
        var user = new User(name, surname, null, null);
        user.addListBank(bank);
        bank.getUsers().add(user);
        return user;
    }

    public Bank createBank(String name) {
        var bank = new Bank(name);
        _banks.add(bank);
        return bank;
    }

    public User addClientAddress(User user, String address) {
        UserBuilder builder = new UserBuilder();
        var userBuilder = new UserBuilder();
        userBuilder.addName(user.getFirstName());
        userBuilder.addSurname(user.GetLastName());
        userBuilder.addAddress(address);
        userBuilder.addPassport(user.GetPassport());
        User newUser = userBuilder.Build();
        return newUser;
    }

    public User addClientPassport(User user, int passport) {
        var builder = new UserBuilder();
        var userBuilder = new UserBuilder();
        userBuilder.addName(user.getFirstName());
        userBuilder.addSurname(user.GetLastName());
        userBuilder.addAddress(user.GetAddress());
        userBuilder.addPassport(passport);
        User newUser = userBuilder.Build();
        return newUser;
    }

    public void percentsAccrual(LocalDate begin, LocalDate end) {
        Integer yearStart = begin.getYear() * 365;
        Integer monthStart = begin.getMonthValue() * 30;
        Integer dayStart = begin.getDayOfMonth();
        Integer yearEnd = end.getYear() * 365;
        Integer monthEnd = end.getMonthValue() * 30;
        Integer dayEnd = end.getDayOfMonth();
        Integer totalStart = yearStart + monthStart + dayStart;
        Integer totalEnd = yearEnd + monthEnd + dayEnd;
        int x = totalEnd - totalStart;
        for (Bank bank : _banks) {
            for (BankAccount bankAccount : bank.getBankAccounts()) {
                Integer creditPercent = bankAccount.getMinusPercents();
                if (creditPercent != 0) {
                    bankAccount.addTimePassPercentsM(bankAccount, x / 30);
                }

                Integer debitDepositPercent = bankAccount.getPlusPercents();
                if (debitDepositPercent != 0) {
                    bankAccount.addTimePassPercentsP(bankAccount, x / 30);
                }
            }
        }
    }
}