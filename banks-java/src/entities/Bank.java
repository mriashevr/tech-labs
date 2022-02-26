package entities;

import bankAccountTypes.CreditBankAccount;
import bankAccountTypes.DebitBankAccount;
import bankAccountTypes.DepositBankAccount;
import observers.IObservable;
import observers.IObserver;
import tools.BanksException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Bank implements IObservable {
    private List<Offer> Offers;
    private String Name;
    private List<User> Users;
    private List<BankAccount> BankAccounts;
    private List<Transaction> Transactions;
    private List<IObserver> ObserverNotifications;

    public Bank(String name) {
        Name = name;
        Users = new ArrayList<User>();
        BankAccounts = new ArrayList<BankAccount>();
        Offers = new ArrayList<Offer>();
        Transactions = new ArrayList<Transaction>();
        ObserverNotifications = new ArrayList<IObserver>();
    }

    public List<Offer> getOffers() {
        return Offers;
    }

    public void setOffers(ArrayList<Offer> offers) {
        Offers = offers;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<User> getUsers() {
        return Users;
    }

    public void setUsers(ArrayList<User> users) {
        Users = users;
    }

    public List<BankAccount> getBankAccounts() {
        return BankAccounts;
    }

    public void setBankAccounts(ArrayList<BankAccount> bankAccounts) {
        BankAccounts = bankAccounts;
    }

    public List<Transaction> getTransactions() {
        return Transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        Transactions = transactions;
    }

    public List<IObserver> getObserverNotifications() {
        return ObserverNotifications;
    }

    public void setObserverNotifications(ArrayList<IObserver> observerNotifications) {
        ObserverNotifications = observerNotifications;
    }

    public void addNewOffer(int percentage) {
        Offers.add(new Offer(percentage));
    }

    public BankAccount createDepositBankAccount(Bank bank, int offerNumber, User user) {
        var deposit = new DepositBankAccount(bank, user);
        deposit.changePlusPercents(deposit, Objects.requireNonNull(bank.Offers.stream().filter((offer) ->
                        offer.getOfferNumber() == offerNumber)
                .findFirst().orElse(null)));
        return deposit;
    }

    public BankAccount createDebitBankAccount(Bank bank, int offerNumber, User user) {
        var debit = new DebitBankAccount(bank, user);
        debit.changePlusPercents(debit, Objects.requireNonNull(bank.Offers.stream().filter((offer) ->
                        offer.getOfferNumber() == offerNumber)
                .findFirst().orElse(null)));
        return debit;
    }

    public BankAccount createCreditBankAccount(Bank bank, int offerNumber, User user) {
        var credit = new CreditBankAccount(bank, user);
        credit.changeMinusPercents(credit, Objects.requireNonNull(bank.Offers.stream().filter((offer) ->
                        offer.getOfferNumber() == offerNumber)
                .findFirst().orElse(null)));
        return credit;
    }

    public Transaction cancelTransaction(UUID transactionId) throws BanksException {
        Transaction transaction = Transactions.stream().filter((trans) -> trans.getId() == transactionId)
                .findFirst().orElse(null);

        if (transaction == null) {
            throw new BanksException("transaction not found");
        }

        if (transaction.getMayBeCanceled()) {
            if (transaction.getAccountTo() == null) {
                transaction.getAccountFrom().topUpMoney(transaction.getSum());
                transaction.DeclineTransaction();
                return transaction;
            }

            if (transaction.getAccountFrom() == null) {
                transaction.getAccountTo().withdrawMoney(transaction.getSum());
                transaction.DeclineTransaction();
                return transaction;
            }

            transaction.getAccountFrom().transferMoney(transaction.getAccountFrom(), transaction.getSum());
            transaction.DeclineTransaction();
        }

        return transaction;
    }

    public void addObserver(IObserver observer) {
        ObserverNotifications.add(observer);
    }

    public void removeObserver(IObserver observer) {
        ObserverNotifications.remove(observer);
    }

    public void notification(BankAccount bankAccount, Transaction transaction) {
        for (IObserver observer : ObserverNotifications) {
            observer.notify(bankAccount, transaction);
        }
    }
}