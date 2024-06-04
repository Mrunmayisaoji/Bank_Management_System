package dev.codescreen.Model;

import java.sql.Date;

public class transactionResponseModel {

    private int amount;
    private int balance;
    private String message;
    private String transactionType;
    private long accountId;
    private long entryId;
    private Date transactionDate;


    public long getEntryId() {
        return entryId;
    }
    
    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setEntryId(long entryId) {
        this.entryId = entryId;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getTransactionType() {
        return transactionType;
    }
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    public long getAccountId() {
        return accountId;
    }
    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
    

    public transactionResponseModel() {
    }

    @Override
    public String toString() {
        return "transactionResponseModel [amount=" + amount + ", balance=" + balance + ", message=" + message
                + ", transactionType=" + transactionType + ", accountId=" + accountId + ", entryId=" + entryId
                + ", transactionDate=" + transactionDate + "]";
    }
    

    
}
