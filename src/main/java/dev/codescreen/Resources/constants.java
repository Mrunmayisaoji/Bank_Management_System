package dev.codescreen.Resources;

public abstract class constants {
    
    public static int AMOUNT_LIMIT = 100000;
    public static String DEPOSIT = "DEPOSIT";
    public static String WITHDRAW = "WITHDRAW";
    public static String CHECK_BALANCE = "CHECK BALANCE";

    public static String SQL_DEPOSIT_WITHDRAW = "UPDATE accounts set balance = ? where accountId = ? ";
    public static String SQL_GET_BALANCE = "select balance from accounts where accountId = ?";
    public static String SQL_PASSBOOK = "insert into passbook (transactionTime,accountId,userId,transactionType,balance) values (?,?,?,?,?)";
    public static String SQL_GET_PASSBOOK = "select * from passbook where accountId = ?";

}
