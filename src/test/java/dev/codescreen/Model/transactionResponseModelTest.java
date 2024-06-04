package dev.codescreen.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class transactionResponseModelTest {

    private transactionResponseModel transactionResponse;

    @BeforeEach
    void setUp() {
        transactionResponse = new transactionResponseModel();
    }

    @Test
    void testAmountHandling() {
        int amount = 500;
        transactionResponse.setAmount(amount);
        assertEquals(amount, transactionResponse.getAmount(), "Amount should be set and retrieved correctly.");
    }

    @Test
    void testBalanceHandling() {
        int balance = 1500;
        transactionResponse.setBalance(balance);
        assertEquals(balance, transactionResponse.getBalance(), "Balance should be set and retrieved correctly.");
    }

    @Test
    void testMessageHandling() {
        String message = "Transaction completed successfully.";
        transactionResponse.setMessage(message);
        assertEquals(message, transactionResponse.getMessage(), "Message should be set and retrieved correctly.");
    }

    @Test
    void testTransactionTypeHandling() {
        String transactionType = "DEPOSIT";
        transactionResponse.setTransactionType(transactionType);
        assertEquals(transactionType, transactionResponse.getTransactionType(), "Transaction type should be set and retrieved correctly.");
    }

    @Test
    void testAccountIdHandling() {
        long accountId = 123456789L;
        transactionResponse.setAccountId(accountId);
        assertEquals(accountId, transactionResponse.getAccountId(), "Account ID should be set and retrieved correctly.");
    }


    @Test
    void testGetEntryId() {
        
    }

    @Test
    void testSetEntryId() {
        
    }
}
