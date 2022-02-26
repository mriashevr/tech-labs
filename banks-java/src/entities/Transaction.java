package entities;

import java.util.UUID;

public class Transaction {
    private BankAccount accountFrom;
    private BankAccount accountTo;
    private Integer sum;
    private Boolean mayBeCanceled;

    public Transaction(BankAccount accountFrom, BankAccount accountTo, int sum) {
        id = UUID.randomUUID();
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.sum = sum;
        mayBeCanceled = true;
    }

    public BankAccount getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(BankAccount accountFrom) {
        this.accountFrom = accountFrom;
    }

    public BankAccount getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(BankAccount accountTo) {
        this.accountTo = accountTo;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Boolean getMayBeCanceled() {
        return mayBeCanceled;
    }

    public void setMayBeCanceled(Boolean mayBeCanceled) {
        this.mayBeCanceled = mayBeCanceled;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID id;

    public void DeclineTransaction() {
        mayBeCanceled = false;
    }
}