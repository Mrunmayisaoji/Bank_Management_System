package dev.codescreen.Controller;

import org.springframework.web.bind.annotation.RestController;

import dev.codescreen.Model.accountModel;
import dev.codescreen.Model.pingModel;
import dev.codescreen.Model.transactionResponseModel;
import dev.codescreen.Service.transactionServiceImpl;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class RestFulController {

    @Autowired
    transactionServiceImpl transactionService = new transactionServiceImpl();

    @GetMapping("/bankApp/ping")
    public pingModel serviceHealthCheckPing() {
        return new pingModel(new Date());
            
    }
    
    @PutMapping("/bankApp/transact")
    public transactionResponseModel userTransaction(@RequestBody accountModel transaction) {
        transactionResponseModel transactionResponse = new transactionResponseModel();
        if (transaction != null){
            transactionResponse = transactionService.executeTransaction(transaction);
        }
        return transactionResponse;
    }

    @GetMapping("bankApp/login")
    public String userLogin(@RequestParam String param) {
        return new String();
    }

    @GetMapping("/bankApp/passbook")
    public ArrayList<transactionResponseModel> getPassbookEntries(@RequestBody accountModel transaction) {
        ArrayList<transactionResponseModel> transactionResponse = new ArrayList<>();
        if (transaction != null){
            transactionResponse = transactionService.getPassbookEntries(transaction);
        }
        return transactionResponse;
    }
    
}
