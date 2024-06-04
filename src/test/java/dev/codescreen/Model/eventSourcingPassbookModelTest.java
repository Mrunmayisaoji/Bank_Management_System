package dev.codescreen.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class eventSourcingPassbookModelTest {

    private eventSourcingPassbookModel passbook;
    private final Date transactionTime = new Date(System.currentTimeMillis());
    private final long accountId = 123456789L;
    private final int userId = 1001;
    private final String transactionType = "DEPOSIT";

    @BeforeEach
    void setUp() {
        passbook = new eventSourcingPassbookModel(transactionTime, accountId, userId, transactionType);
    }

    @Test
    void testGetTransactionTime() {
        assertEquals(transactionTime, passbook.getTranscationTime());
    }

    @Test
    void testSetTransactionTime() {
        Date newTransactionTime = new Date(transactionTime.getTime() + 1000000); // Adjusting the time for the test
        passbook.setTranscationTime(newTransactionTime);
        assertEquals(newTransactionTime, passbook.getTranscationTime());
    }

    @Test
    void testGetAccountId() {
        assertEquals(accountId, passbook.getAccountId());
    }

    @Test
    void testSetAccountId() {
        long newAccountId = 987654321L;
        passbook.setAccountId(newAccountId);
        assertEquals(newAccountId, passbook.getAccountId());
    }

    @Test
    void testGetUserId() {
        assertEquals(userId, passbook.getUserId());
    }

    @Test
    void testSetUserId() {
        int newUserId = 2002;
        passbook.setUserId(newUserId);
        assertEquals(newUserId, passbook.getUserId());
    }

    @Test
    void testGetTransactionType() {
        assertEquals(transactionType, passbook.getTransactionType());
    }

    @Test
    void testSetTransactionType() {
        String newTransactionType = "WITHDRAW";
        passbook.setTransactionType(newTransactionType);
        assertEquals(newTransactionType, passbook.getTransactionType());
    }

    @Test
    void testToString() {
        String expectedString = "eventSourcingPassbookModel [transcationTime=" + transactionTime + ", accountId=" + accountId
                + ", userId=" + userId + ", TransactionType=" + transactionType + "]";
        assertEquals(expectedString, passbook.toString());
    }
}
