package dev.codescreen.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import dev.codescreen.Model.accountModel;
import dev.codescreen.Model.pingModel;
import dev.codescreen.Model.transactionResponseModel;
import dev.codescreen.Service.transactionServiceImpl;
import java.util.Date;

@WebMvcTest(RestFulController.class)
public class RestFulControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private transactionServiceImpl transactionService;

    @Test
    public void testServiceHealthCheckPing() throws Exception {
        mockMvc.perform(get("/bankApp/ping"))
               .andExpect(status().isOk());
    }

    @Test
    public void testUserTransaction() throws Exception {
        accountModel dummyAccount = new accountModel(1L, 100, new java.sql.Date(new Date().getTime()), "DEPOSIT", "USD", 1000);
        transactionResponseModel expectedResponse = new transactionResponseModel();
        expectedResponse.setAmount(100);
        expectedResponse.setBalance(1100);
        expectedResponse.setMessage("Transaction Successful");

        when(transactionService.executeTransaction(any(accountModel.class))).thenReturn(expectedResponse);

        mockMvc.perform(put("/bankApp/transact")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"accountId\":1,\"amount\":100,\"dateOfTransaction\":\"2021-06-15\",\"transactionType\":\"DEPOSIT\",\"currency\":\"USD\",\"balance\":1000}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUserLogin() throws Exception {
        mockMvc.perform(get("/bankApp/login")
               .param("param", "value"))
               .andExpect(status().isOk());
    }
}
