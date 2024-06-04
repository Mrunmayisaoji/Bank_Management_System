package dev.codescreen.Dao;

import java.util.ArrayList;

import dev.codescreen.Model.accountModel;
import dev.codescreen.Model.transactionResponseModel;


public interface transactionDao {
    
    public transactionResponseModel depositTransaction(accountModel transaction);
    public transactionResponseModel withdrawTransaction(accountModel transaction);
    public transactionResponseModel checkBalanceTransaction(accountModel transaction);
    public ArrayList<transactionResponseModel> getPassbookEntries(accountModel transaction);

}
