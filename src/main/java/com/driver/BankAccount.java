package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public double getBalance() {
        return balance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        if(digits*9<sum) throw new Exception("Account Number can not be generated");
        StringBuilder acNo = new StringBuilder();
        int num = 9;
        while(sum!=0){
            if(num<=sum){
                sum-=num;
                acNo.append(num);
            }
            else num = sum;
        }
        while(acNo.length()<digits) acNo.append(0);

        return acNo.toString();
    }

    public void deposit(double amount) {
        //add amount to balance
        balance+=amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(balance-amount<minBalance) throw new Exception("Insufficient Balance");
        else balance-=amount;
    }

}