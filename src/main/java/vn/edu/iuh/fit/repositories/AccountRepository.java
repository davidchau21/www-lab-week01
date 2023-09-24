package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.db.ConnectDB;
import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.models.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public List<Account> getAllAcc() {
        List<Account> accounts = new ArrayList<>();
        String query = "SELECT * FROM account";
        try {
            connection = new ConnectDB().getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                accounts.add(new Account(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        Status.fromCode(resultSet.getInt("status"))));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return accounts;
    }

    public Account login(String email, String password) {
        String query = "select * from account where email = ? and password = ?";
        try {
            connection = new ConnectDB().getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Account account = new Account(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        Status.fromCode(resultSet.getInt("status")));

                return account;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

}
