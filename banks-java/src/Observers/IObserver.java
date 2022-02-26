package Observers;

import Entities.BankAccount;
import Entities.Transaction;

public interface IObserver
{
    void Notify(BankAccount bankAccount, Transaction transaction);
}