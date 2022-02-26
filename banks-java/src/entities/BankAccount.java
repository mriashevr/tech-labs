package entities;

import observers.IObserver;
import tools.BanksException;

import java.util.UUID;

public abstract class BankAccount implements IObserver {
    private final Integer maxTransferingForSuspiciousUsers = 30000;
    private UUID id;
    private Bank bank;
    private Integer moneySum;
    private Integer plusPercents;
    private Integer moneyDebt;
    private Integer minusPercents;

    public BankAccount(Bank bank, User user) {
        this.user = user;
        this.bank = bank;
        plusPercents = 1;
        id = UUID.randomUUID();
        moneySum = 0;
        moneyDebt = null;
        minusPercents = null;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Integer getMoneySum() {
        return moneySum;
    }

    public void setMoneySum(Integer moneySum) {
        this.moneySum = moneySum;
    }

    public Integer getPlusPercents() {
        return plusPercents;
    }

    public void setPlusPercents(Integer plusPercents) {
        this.plusPercents = plusPercents;
    }

    public Integer getMoneyDebt() {
        return moneyDebt;
    }

    public void setMoneyDebt(Integer moneyDebt) {
        this.moneyDebt = moneyDebt;
    }

    public Integer getMinusPercents() {
        return minusPercents;
    }

    public void setMinusPercents(Integer minusPercents) {
        this.minusPercents = minusPercents;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User user;

    public BankAccount addTimePassPercentsM(BankAccount bankAccount, int month) {
        bankAccount.moneyDebt += bankAccount.moneyDebt * bankAccount.minusPercents;
        return bankAccount;
    }

    public BankAccount addTimePassPercentsP(BankAccount bankAccount, int month) {
        bankAccount.moneySum += bankAccount.moneySum * bankAccount.plusPercents;
        return bankAccount;
    }

    public BankAccount changePlusPercents(BankAccount bankAccount, Offer x) {
        bankAccount.plusPercents = x.getPercentage();
        return this;
    }

    public BankAccount changeMinusPercents(BankAccount bankAccount, Offer x) {
        bankAccount.minusPercents = x.getPercentage();
        return bankAccount;
    }

    public BankAccount withdrawMoney(int money) throws BanksException {
        if (moneySum >= money) {
            moneySum -= money;
            bank.getTransactions().add(new Transaction(this, null, money));
            return this;
        }

        throw new BanksException("not enough money");
    }

    public BankAccount transferMoney(BankAccount bankAccountEnd, int money) throws BanksException {
        if (!user.validation() && money > maxTransferingForSuspiciousUsers) {
            throw new BanksException("sus, passport required");
        }

        if (moneySum >= money) {
            moneySum -= money;
            UUID id = UUID.randomUUID();
            bank.getTransactions().add(new Transaction(this, bankAccountEnd, money));
            bankAccountEnd.moneySum += money;
            return this;
        }

        throw new BanksException("not enough money to complete the transfer");
    }

    public BankAccount topUpMoney(int money) {
        moneySum += money;
        bank.getTransactions().add(new Transaction(null, this, money));
        return this;
    }

    public void notify(BankAccount bankAccount, Transaction transaction) {
        System.out.println("The transaction completed:" + transaction);
    }
}