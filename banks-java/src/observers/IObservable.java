package observers;

import entities.BankAccount;
import entities.Transaction;

public interface IObservable
{
    void addObserver(IObserver observer);
    void removeObserver(IObserver observer);
    void notification(BankAccount bankAccount, Transaction transaction);
}