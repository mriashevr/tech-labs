package bankAccountTypes;

import entities.*;

public class DebitBankAccount extends BankAccount {
    public DebitBankAccount(Bank bank, User user) {
        super(bank, user);
    }
}