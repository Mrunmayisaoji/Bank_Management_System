package dev.codescreen.Service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dev.codescreen.Dao.transactionDaoImpl;
import dev.codescreen.Model.accountModel;
import dev.codescreen.Model.transactionResponseModel;
import dev.codescreen.Resources.constants;

@Service
@Component
public class transactionServiceImpl implements transactionService{

    transactionDaoImpl transactionDao = new transactionDaoImpl();
    
    public transactionResponseModel executeTransaction(accountModel transaction) {
        transactionResponseModel txn = new transactionResponseModel();

        if (transaction.getAmount()< constants.AMOUNT_LIMIT){


            if (transaction.getTransactionType().equals(constants.DEPOSIT)){
                txn = transactionDao.depositTransaction(transaction);
            }
            if (transaction.getTransactionType().equals(constants.WITHDRAW)){
                txn = transactionDao.withdrawTransaction(transaction);
            }
            if(transaction.getTransactionType().equals(constants.CHECK_BALANCE)){
                txn = transactionDao.checkBalanceTransaction(transaction);
            }
        }
        return txn;
    }

    @Override
    public ArrayList<transactionResponseModel> getPassbookEntries(accountModel transaction) {
        ArrayList<transactionResponseModel> passbookEntries = new ArrayList<>();

        passbookEntries = transactionDao.getPassbookEntries(transaction);
        System.out.println(passbookEntries.size());
        return passbookEntries;
    }
    
}
