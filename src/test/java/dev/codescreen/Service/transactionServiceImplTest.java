package dev.codescreen.Service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dev.codescreen.Dao.transactionDaoImpl;
import dev.codescreen.Model.accountModel;
import dev.codescreen.Model.transactionResponseModel;
import dev.codescreen.Resources.constants;

public class transactionServiceImplTest {

    @Mock
    private transactionDaoImpl transactionDao; // Mock the DAO layer

    @InjectMocks
    private transactionServiceImpl transactionService; // Service layer with injected mocks

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testExecuteTransaction_Deposit() {
        accountModel account = new accountModel();
        account.setTransactionType(constants.DEPOSIT);
        account.setAmount(500); 

        transactionResponseModel expectedResponse = new transactionResponseModel();
        expectedResponse.setMessage("Amount Deposited Successfully");

        when(transactionDao.depositTransaction(account)).thenReturn(expectedResponse);

        transactionResponseModel result = transactionService.executeTransaction(account);
        assertEquals("Amount Deposited Successfully", result.getMessage());
        verify(transactionDao).depositTransaction(account);
    }

    @Test
    void testExecuteTransaction_Withdraw() {
        accountModel account = new accountModel();
        account.setTransactionType(constants.WITHDRAW);
        account.setAmount(300); // Below the AMOUNT_LIMIT

        transactionResponseModel expectedResponse = new transactionResponseModel();
        expectedResponse.setMessage("Amount Withdrawn Successfully");

        when(transactionDao.withdrawTransaction(account)).thenReturn(expectedResponse);

        transactionResponseModel result = transactionService.executeTransaction(account);
        assertEquals("Amount Withdrawn Successfully", result.getMessage());
        verify(transactionDao).withdrawTransaction(account);
    }

    @Test
    void testGetPassbookEntries() {
        accountModel account = new accountModel();
        ArrayList<transactionResponseModel> expectedEntries = new ArrayList<>();
        expectedEntries.add(new transactionResponseModel());
        
        when(transactionDao.getPassbookEntries(account)).thenReturn(expectedEntries);

        ArrayList<transactionResponseModel> entries = transactionService.getPassbookEntries(account);
        assertNotNull(entries);
        assertEquals(1, entries.size());
        verify(transactionDao).getPassbookEntries(account);
    }
}
