package dev.codescreen.Model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="passbook")
public class eventSourcingPassbookModel {

    private Date transcationTime;
    @Id
    private long accountId;
    private int userId;
    private String TransactionType;

    public Date getTranscationTime() {
        return transcationTime;
    }
    public void setTranscationTime(Date transcationTime) {
        this.transcationTime = transcationTime;
    }
    public long getAccountId() {
        return accountId;
    }
    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getTransactionType() {
        return TransactionType;
    }
    public void setTransactionType(String transactionType) {
        TransactionType = transactionType;
    }
    public eventSourcingPassbookModel(Date transcationTime, long accountId, int userId, String transactionType) {
        this.transcationTime = transcationTime;
        this.accountId = accountId;
        this.userId = userId;
        TransactionType = transactionType;
    }
    @Override
    public String toString() {
        return "eventSourcingPassbookModel [transcationTime=" + transcationTime + ", accountId=" + accountId
                + ", userId=" + userId + ", TransactionType=" + TransactionType + "]";
    }

    
    
}
