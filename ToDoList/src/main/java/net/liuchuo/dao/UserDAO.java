package net.liuchuo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

    private Connection connection;

    public UserDAO() {
        connection = DatabaseConnect.getConnection();
    }

    public boolean isMatch(String username, String password) throws SQLException {
        String sql = "select username from user where username = " + username +
                " and password = " + password;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet.next();
    }
}
