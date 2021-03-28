package model.entities;

import model.exception.DomainException;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withDrawLimit;

    public Account(Integer number, String holder, Double balance, Double withDrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withDrawLimit = withDrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithDrawLimit() {
        return withDrawLimit;
    }

    public void setWithDrawLimit(Double withDrawLimit) {
        this.withDrawLimit = withDrawLimit;
    }


    public void deposit(Double amount){

          balance += amount;
    }


    public void withDraw(Double amount){

        if(amount > balance) {
            throw new DomainException("Not enough balance");
        }
        else if(amount > withDrawLimit){
            throw new DomainException("The amount exceeds withdraw limit");
        }
        else{
            balance -= amount;
        }

    }

    @Override
    public String toString() {
        return "New Balance: " + balance;
    }
}
