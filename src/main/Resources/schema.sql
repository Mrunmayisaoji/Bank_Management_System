CREATE TABLE IF NOT EXISTS accounts (
    accountId Long NOT NULL,
    currency VARCHAR(3),
    balance INT,
    PRIMARY KEY(accountId)
);


create table passbook
(
entryId long NOT NULL PRIMARY KEY AUTO_INCREMENT,
transactionTime date NOT NULL,
accountId long NOT NULL,
userId int NOT NULL,
balance int NOT NULL,
transactionType varchar(50) NOT NULL
);

commit;