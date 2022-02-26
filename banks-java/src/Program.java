import entities.Bank;
import entities.BankAccount;
import entities.User;
import services.CentralBank;
import tools.BanksException;

import java.util.Objects;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws BanksException {
        Scanner scanner = new Scanner(System.in);
        CentralBank centralBank = new CentralBank();
        Bank bank = centralBank.createBank("DVBank");
        bank.addNewOffer(3);
        bank.addNewOffer(7);
        User transferringUser = centralBank.createUser("hope", "itdwork", bank);
        BankAccount trba = bank.createDebitBankAccount(bank, 1, transferringUser);
        System.out.println("Would you like to open a bank account in DV Bank?");
        System.out.println("1 - Yes");
        System.out.println("2 - No");
        Integer x = Integer.valueOf(scanner.next());
        if (x == 1) {
            System.out.println("Please, enter your name");
            String name = scanner.next();
            System.out.println("Plz, enter your surname");
            String surname = scanner.next();

            User user = centralBank.createUser(name, surname, bank);

            System.out.println("Would you like to enter address data?");
            String a = scanner.next();
            if (Objects.equals(a, "yes")) {
                String address = scanner.next();
                user.setAddress(address);
            }

            System.out.println("Would you like to enter passport data?");
            String b = scanner.next();
            if (Objects.equals(b, "yes")) {
                String q = scanner.next();
                Integer passport = Integer.valueOf(q);
                user.setPassport(passport);
            }

            System.out.println("What kind of account you want? 1 - Credit, 2 - Debit, 3 - Deposit");
            Integer account = Integer.valueOf(scanner.next());
            BankAccount bankAccount = null;

            if (account == 1) {
                System.out.println("Please choose an offer for credit account: 1 -" + bank.getOffers().get(0).getPercentage() + "2 - " +
                        bank.getOffers().get(1).getPercentage());
                Integer c = Integer.valueOf(scanner.next());
                if (c == 1) {
                    Integer offerNumber = 1;
                    bankAccount = bank.createCreditBankAccount(bank, (bank.getOffers().stream().filter((offer) ->
                                    offer.getOfferNumber() == offerNumber)
                            .findFirst().orElse(null)).getPercentage(), user);
                } else {
                    Integer offerNumber = 2;
                    bankAccount = bank.createCreditBankAccount(bank, (bank.getOffers().stream().filter((offer) ->
                                    offer.getOfferNumber() == offerNumber)
                            .findFirst().orElse(null)).getPercentage(), user);
                }

                System.out.println("Perfect, now you have a credit card");
            } else if (account == 3) {
                System.out.println("Please choose an offer for deposit account: 1 -" + bank.getOffers().get(0).getPercentage()
                        + "2 - " + bank.getOffers().get(1).getPercentage());
                String c = scanner.next();
                if (c == "1") {
                    Integer offerNumber = 0;
                    bankAccount = bank.createDepositBankAccount(bank, (Objects.requireNonNull(bank.getOffers().stream().filter((offer) ->
                                    offer.getOfferNumber() == offerNumber)
                            .findFirst().orElse(null))).getOfferNumber(), user);
                } else {
                    Integer offerNumber = 1;
                    bankAccount = bank.createDepositBankAccount(bank, (Objects.requireNonNull(bank.getOffers().stream().filter((offer) ->
                                    offer.getOfferNumber() == offerNumber)
                            .findFirst().orElse(null))).getOfferNumber(), user);
                }

                System.out.println("Perfect, now you have a deposit card");
            } else if (account == 2) {
                bankAccount = bank.createDebitBankAccount(bank, 1, user);
                System.out.println("Perfect, now you have a debit card");
            }

            System.out.println("Now you can do operations with your card. 1 - TopUp, 2 - Withdraw, 3 - Transfer");
            Integer operation = Integer.valueOf(scanner.next());
            if (operation == 1) {
                System.out.println("Enter sum you want to top up");
                String m = scanner.next();
                Integer money = Integer.valueOf(m);
                bankAccount.topUpMoney(money);
            } else if (operation == 2) {
                System.out.println("Enter sum you want to withdraw");
                String m = scanner.next();
                Integer money = Integer.valueOf(m);
                bankAccount.withdrawMoney(money);
            } else if (operation == 3) {
                System.out.println("Enter sum you want to transfer");
                String m = scanner.next();
                Integer money = Integer.valueOf(m);
                bankAccount.transferMoney(trba, money);
            }
        }
    }
}
