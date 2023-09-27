package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.repositories.AccountRepository;

import java.util.List;

public class AccountServices {
    private static AccountRepository accountDao = new AccountRepository();

    public static void insertAccount(Account account) {
        accountDao.insertAccount(account);
    }

    public static Account searchAccount(String id) {
        return accountDao.searchAccount(id);
    }

    public static void dellAccount(String id) {
        accountDao.dellAccount(id);
    }

    public static List<Account> getAccounts() {
        return accountDao.getAccounts();
    }
}
