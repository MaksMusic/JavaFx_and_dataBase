package com.example.javafxanddatabase.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountService {

    private DataBaseConnectionManager dataBaseConnectionManager;
    private List<AccountDAO> accountList = new ArrayList<>();

    public AccountService() {
        this.dataBaseConnectionManager = new DataBaseConnectionManager(
                "jdbc:postgresql://127.0.0.1:5432/loginAcc", "postgres", "postgres");

    }

    public int addAcc(final String login, final String password) {
        String insertQuery = "INSERT INTO user_acc (login_user,password_user) VALUES (?, ?)";
        try (Connection connection = dataBaseConnectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

           return  preparedStatement.executeUpdate();
        } catch (SQLException e) {
            return 0;
        }
    }

    public List<AccountDAO> getListAcc(){
        String insertQuery = "SELECT * FROM user_acc";
        //String insertQuery = "SELECT  FROM user_acc";
        try (Connection conn = dataBaseConnectionManager.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(insertQuery);
             ResultSet rs = preparedStatement.executeQuery();
        ) {


            while (rs.next()){
                int id = rs.getInt("id_user");
                String login = rs.getString("login_user");
                String password = rs.getString("password_user");
                AccountDAO accountDAO = new AccountDAO(id,login,password);
                accountList.add(accountDAO);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return accountList;
    }
}
