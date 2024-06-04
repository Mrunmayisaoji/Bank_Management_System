package dev.codescreen.Dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import dev.codescreen.Model.accountModel;
import dev.codescreen.Model.transactionResponseModel;
import dev.codescreen.Resources.JdbcCOnnectionFactory;
import dev.codescreen.Resources.constants;

@Repository
@Component
public class transactionDaoImpl implements transactionDao{

    JdbcCOnnectionFactory conn;

    
    @Override
    public transactionResponseModel depositTransaction(accountModel transaction) {
    transactionResponseModel txn = new transactionResponseModel();
    PreparedStatement ps;
    String checkBalanceSql = constants.SQL_GET_BALANCE;
    String withdrawSql = constants.SQL_DEPOSIT_WITHDRAW;
    String passbookSql = constants.SQL_PASSBOOK;
    int previousBalance=0;
    int balanceAfterDeposit;

    try {
        ps = conn.getConnection().prepareStatement(checkBalanceSql);
        ps.setLong(1, transaction.getAccountId());  // Adjust the index here
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            previousBalance = rs.getInt("balance");
            balanceAfterDeposit = transaction.getAmount() + previousBalance;

            ps = conn.getConnection().prepareStatement(withdrawSql);
            ps.setInt(1, balanceAfterDeposit);
            ps.setLong(2, transaction.getAccountId());
            ps.executeUpdate(); 

            Date currentDate = new Date(System.currentTimeMillis());
            ps = conn.getConnection().prepareStatement(passbookSql);
            ps.setDate(1, currentDate);
            ps.setLong(2, transaction.getAccountId());
            ps.setInt(3, transaction.getAmount());
            ps.setString(4, constants.DEPOSIT);
            ps.setInt(5, balanceAfterDeposit);
            ps.executeUpdate();

            txn.setAccountId(transaction.getAccountId());
            txn.setAmount(transaction.getAmount());
            txn.setBalance(balanceAfterDeposit);
            txn.setMessage("Amount Deposited Successfully");
            txn.setTransactionType(constants.DEPOSIT);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return txn;
}


    @Override
    public transactionResponseModel withdrawTransaction(accountModel transaction) {
        transactionResponseModel txn = new transactionResponseModel();
        PreparedStatement ps;
        String checkBalanceSql = constants.SQL_GET_BALANCE;
        String withdrawSql = constants.SQL_DEPOSIT_WITHDRAW;
        String passbookSql = constants.SQL_PASSBOOK;
        int previousBalance=0;
        int balanceAfterWithdraw;
    
        try {
            ps = conn.getConnection().prepareStatement(checkBalanceSql);
            ps.setLong(1, transaction.getAccountId());  // Adjust the index here
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                previousBalance = rs.getInt("balance");
                balanceAfterWithdraw = previousBalance - transaction.getAmount();
    
                ps = conn.getConnection().prepareStatement(withdrawSql);
                ps.setInt(1, balanceAfterWithdraw);
                ps.setLong(2, transaction.getAccountId());
                ps.executeUpdate();
    
                Date currentDate = new Date(System.currentTimeMillis());
                ps = conn.getConnection().prepareStatement(passbookSql);
                ps.setDate(1, currentDate);
                ps.setLong(2, transaction.getAccountId());
                ps.setInt(3, transaction.getAmount());
                ps.setString(4, constants.WITHDRAW);
                ps.setInt(5, balanceAfterWithdraw);
                ps.executeUpdate(); 
    
                txn.setAccountId(transaction.getAccountId());
                txn.setAmount(transaction.getAmount());
                txn.setBalance(balanceAfterWithdraw);
                txn.setMessage("Amount Wihtdrawn Successfully");
                txn.setTransactionType(constants.WITHDRAW);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return txn;
    }



    @Override
    public transactionResponseModel checkBalanceTransaction(accountModel transaction) {

        transactionResponseModel txn = new transactionResponseModel();
        PreparedStatement ps;
        String checkBalanceSql = constants.SQL_GET_BALANCE;
        String passbookSql = constants.SQL_PASSBOOK;
        int balance=0;

    
        try {
            ps = conn.getConnection().prepareStatement(checkBalanceSql);
            ps.setLong(1, transaction.getAccountId()); 
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                balance = rs.getInt("balance");
                
                Date currentDate = new Date(System.currentTimeMillis());
                ps = conn.getConnection().prepareStatement(passbookSql);
                ps.setDate(1, currentDate);
                ps.setLong(2, transaction.getAccountId());
                ps.setInt(3, transaction.getAmount());
                ps.setString(4, constants.CHECK_BALANCE);
                ps.setInt(5, balance);
                ps.executeUpdate(); 
    
                txn.setAccountId(transaction.getAccountId());
                txn.setAmount(transaction.getAmount());
                txn.setBalance(balance);
                txn.setMessage("Balance Checked Successfully");
                txn.setTransactionType(constants.CHECK_BALANCE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
        return txn;
    }


    @Override
    public ArrayList<transactionResponseModel> getPassbookEntries(accountModel transaction) {


        ArrayList<transactionResponseModel> entries = new ArrayList<>();
        PreparedStatement ps;

        try {
            ps = conn.getConnection().prepareStatement(constants.SQL_GET_PASSBOOK);
            ps.setLong(1, transaction.getAccountId());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                transactionResponseModel txn = new transactionResponseModel();
                txn.setEntryId(rs.getLong("entryId"));
                txn.setAccountId(rs.getLong("accountId"));
                txn.setBalance(rs.getInt("balance"));
                txn.setTransactionType(rs.getString("transactionType"));
                txn.setTransactionDate(rs.getDate("transactionTime"));
                entries.add(txn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entries;
    }

    
}
