package dev.codescreen.Model;

import java.sql.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class accountModel {
    
    @Id
    private long accountId;
    private int amount;
    private Date dateOfTranscation;
    private String transactionType;
    private String Currency;
    private int balance;


    public accountModel(long accountId, int amount, Date dateOfTranscation, String transactionType,
            String currency, int balance) {
        this.accountId = accountId;
        this.amount = amount;
        this.dateOfTranscation = dateOfTranscation;
        this.transactionType = transactionType;
        this.balance = balance;
        Currency = currency;
    }
    
    public accountModel() {
        //TODO Auto-generated constructor stub
    }

    public long getAccountId() {
        return accountId;
    }
    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public Date getDateOfTranscation() {
        return dateOfTranscation;
    }
    public void setDateOfTranscation(Date dateOfTranscation) {
        this.dateOfTranscation = dateOfTranscation;
    }
    public String getTransactionType() {
        return transactionType;
    }
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
    public String getCurrency() {
        return Currency;
    }
    public void setCurrency(String currency) {
        Currency = currency;
    }

    @Override
    public String toString() {
        return "accountModel [accountNumber=" + accountId + ", amount=" + amount + ", dateOfTranscation="
                + dateOfTranscation + ", transactionType=" + transactionType + ", Currency=" + Currency + ", balance="
                + balance + "]";
    }

    

    

}
