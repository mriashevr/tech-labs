package observers;

import entities.BankAccount;
import entities.Transaction;

public interface IObserver {
    void notify(BankAccount bankAccount, Transaction transaction);
}