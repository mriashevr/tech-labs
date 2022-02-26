package Observers;

import Entities.BankAccount;
import Entities.Transaction;

public interface IObservable
{
    void AddObserver(IObserver observer);
    void RemoveObserver(IObserver observer);
    void Notification(BankAccount bankAccount, Transaction transaction);
}