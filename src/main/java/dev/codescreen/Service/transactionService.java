package dev.codescreen.Service;

import java.util.ArrayList;

import dev.codescreen.Model.accountModel;
import dev.codescreen.Model.transactionResponseModel;

public abstract interface transactionService {

    public transactionResponseModel executeTransaction(accountModel transaction);
    public ArrayList<transactionResponseModel> getPassbookEntries(accountModel transaction);
    
} 