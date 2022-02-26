package banksTests;

import Entities.Bank;
import Entities.BankAccount;
import Entities.User;
import Services.CentralBank;
import Tools.BanksException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class banksTests {
    private CentralBank _centralBank;

    @Before
    public void Setup()
    {
        _centralBank = new CentralBank();
    }

    @Test(expected = BanksException.class)
    public void TransferMoneyFromSuspiciousAccount_CatchError() throws BanksException {
        Bank _bank = _centralBank.CreateBank("tink");
        _bank.addNewOffer(3);
        User user1 = _centralBank.CreateUser("maks", "maks", _bank);
        User user2 = _centralBank.CreateUser("den", "maks", _bank);
        BankAccount ba1 = _bank.createDebitBankAccount(_bank, 1, user1);
        BankAccount ba2 = _bank.createDebitBankAccount(_bank, 1, user2);
        ba1.topUpMoney(50000);

        ba1.transferMoney(ba2, 31000);

    }

    @Test
    public void TopUpMoney_CheckBalance()
    {
        Bank _bank = _centralBank.CreateBank("tink");
        _bank.addNewOffer(3);
        User user1 = _centralBank.CreateUser("maks", "maks", _bank);
        BankAccount account = _bank.createDebitBankAccount(_bank, 1, user1);
        Integer amount = 1000;
        account.topUpMoney(amount);
        account.topUpMoney(amount);
        account.topUpMoney(amount);
        Assert.assertEquals(amount * 3, account.getMoneySum(), 0.000001);
    }

    @Test
    public void WithdrawMoney_CheckBalance() throws BanksException {
        Bank _bank = _centralBank.CreateBank("tink");
        _bank.addNewOffer(3);
        User user1 = _centralBank.CreateUser("maks", "maks", _bank);
        BankAccount account = _bank.createDebitBankAccount(_bank, 1, user1);
        Integer amount = 1000;
        account.topUpMoney(amount);
        account.withdrawMoney(amount);
        account.topUpMoney(amount);
        Assert.assertEquals(amount, account.getMoneySum(), 0.000001);
    }

    @Test
    public void TransferMoney_CheckBalances() throws BanksException {
        Bank _bank = _centralBank.CreateBank("tink");
        _bank.addNewOffer(3);
        User user1 = _centralBank.CreateUser("maks", "maks", _bank);
        BankAccount account = _bank.createDebitBankAccount(_bank, 1, user1);
        User user2 = _centralBank.CreateUser("den", "maks", _bank);
        BankAccount account2 = _bank.createDebitBankAccount(_bank, 1, user2);
        account.topUpMoney(5000);
        account.transferMoney(account2, 1000);
        Assert.assertEquals(4000, account.getMoneySum(), 0.000001);
        Assert.assertEquals(1000, account2.getMoneySum(), 0.000001);
    }
}

