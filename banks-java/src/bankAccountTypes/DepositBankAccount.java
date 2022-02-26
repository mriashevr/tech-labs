package bankAccountTypes;

import tools.BanksException;
import entities.*;

public class DepositBankAccount extends BankAccount {
    public @Override
    BankAccount transferMoney(BankAccount bankAccountEnd, int money) throws BanksException {
        throw new BanksException("Not able to transfer money from deposit account");
    }

    public @Override
    BankAccount withdrawMoney(int money) throws BanksException {
        throw new BanksException("Not able to withdraw money from deposit account");
    }

    public DepositBankAccount(Bank bank, User user) {
        super(bank, user);
    }
}