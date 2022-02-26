package BankAccountTypes;

import Entities.*;

public class DebitBankAccount extends BankAccount {
    public DebitBankAccount(Bank bank, User user) {
        super(bank, user);
    }
}