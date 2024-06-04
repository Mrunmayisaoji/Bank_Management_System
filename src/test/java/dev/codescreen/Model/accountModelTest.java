package dev.codescreen.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class accountModelTest {

    private accountModel account;
    private final long accountId = 1L;
    private final int amount = 1000;
    private final Date dateOfTransaction = new Date(System.currentTimeMillis());
    private final String transactionType = "DEPOSIT";
    private final String currency = "USD";
    private final int balance = 5000;

    @BeforeEach
    void setUp() {
        account = new accountModel(accountId, amount, dateOfTransaction, transactionType, currency, balance);
    }

    @Test
    void testGetAccountId() {
        assertEquals(accountId, account.getAccountId());
    }

    @Test
    void testSetAccountId() {
        long newAccountId = 2L;
        account.setAccountId(newAccountId);
        assertEquals(newAccountId, account.getAccountId());
    }

    @Test
    void testGetAmount() {
        assertEquals(amount, account.getAmount());
    }

    @Test
    void testSetAmount() {
        int newAmount = 2000;
        account.setAmount(newAmount);
        assertEquals(newAmount, account.getAmount());
    }

    @Test
    void testGetDateOfTransaction() {
        assertEquals(dateOfTransaction, account.getDateOfTranscation());
    }

    @Test
    void testSetDateOfTransaction() {
        Date newDateOfTransaction = new Date(System.currentTimeMillis() + 1000000);
        account.setDateOfTranscation(newDateOfTransaction);
        assertEquals(newDateOfTransaction, account.getDateOfTranscation());
    }

    @Test
    void testGetTransactionType() {
        assertEquals(transactionType, account.getTransactionType());
    }

    @Test
    void testSetTransactionType() {
        String newTransactionType = "WITHDRAW";
        account.setTransactionType(newTransactionType);
        assertEquals(newTransactionType, account.getTransactionType());
    }

    @Test
    void testGetBalance() {
        assertEquals(balance, account.getBalance());
    }

    @Test
    void testSetBalance() {
        int newBalance = 10000;
        account.setBalance(newBalance);
        assertEquals(newBalance, account.getBalance());
    }

    @Test
    void testGetCurrency() {
        assertEquals(currency, account.getCurrency());
    }

    @Test
    void testSetCurrency() {
        String newCurrency = "EUR";
        account.setCurrency(newCurrency);
        assertEquals(newCurrency, account.getCurrency());
    }

    @Test
    void testToString() {
        String expectedString = "accountModel [accountNumber=" + accountId + ", amount=" + amount + ", dateOfTranscation="
                + dateOfTransaction + ", transactionType=" + transactionType + ", Currency=" + currency + ", balance="
                + balance + "]";
        assertEquals(expectedString, account.toString());
    }
}
