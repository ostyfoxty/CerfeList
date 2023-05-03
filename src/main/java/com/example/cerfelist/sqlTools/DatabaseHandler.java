package com.example.cerfelist.sqlTools;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public void signUpManager(String name, String surname, String position, String login, String password) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.HUMAN_TABLE + "(" + Const.HUMAN_NAME + "," + Const.HUMAN_SURNAME +
                "," + Const.HUMAN_POSITION + "," + Const.HUMAN_LOGIN + "," + Const.HUMAN_PASSWORD + ")" + "VALUES(?,?,?,?,?)";

        PreparedStatement prST = getDbConnection().prepareStatement(insert);
        prST.setString(1, name);
        prST.setString(2, surname);
        prST.setString(3, position);
        prST.setString(4, login);
        prST.setString(5, password);

        prST.executeUpdate();
    }
}
