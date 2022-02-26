package bankAccountTypes;

import entities.*;

public class CreditBankAccount extends BankAccount {
    public CreditBankAccount(Bank bank, User user) {
        super(bank, user);
    }
}