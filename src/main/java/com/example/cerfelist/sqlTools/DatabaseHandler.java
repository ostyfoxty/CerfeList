package com.example.cerfelist.sqlTools;


import com.example.cerfelist.classes.Manager;
import com.example.cerfelist.frames.ReportFrame;
import com.example.cerfelist.frames.SortingWorkerFrame;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    private ResultSet resSet;

    public ResultSet getResSet() {
        return resSet;
    }

    public void setResSet(ResultSet resSet) {
        this.resSet = resSet;
    }

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public void signUpManager(Manager manager) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.HUMAN_TABLE + "(" + Const.HUMAN_NAME + "," + Const.HUMAN_SURNAME +
                "," + Const.HUMAN_POSITION + "," + Const.HUMAN_LOGIN + "," + Const.HUMAN_PASSWORD + ")" + "VALUES(?,?,?,?,?)";

        PreparedStatement prST = getDbConnection().prepareStatement(insert);
        prST.setString(1, manager.getName());
        prST.setString(2, manager.getSurname());
        prST.setString(3, manager.getPosition());
        prST.setString(4, manager.getLogin());
        prST.setString(5, manager.getPassword());

        prST.executeUpdate();
    }

    public void addNewCertificate(String number,String series,String institutionOfCertificate,String reason,
                                  String dateOfCertificate, String workerName,String workerSurname, String daysOfIllness) throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.CERTIFICATE_TABLE + "(" + Const.CERTIFICATE_NUMBER + "," + Const.CERTIFICATE_SERIES+
                "," + Const.CERTIFICATE_INSTITUTION + "," + Const.CERTIFICATE_REASON + "," + Const.CERTIFICATE_DATE+ "," +
                Const.CERTIFICATE_WORKERNAME + "," + Const.CERTIFICATE_WORKERSURNAME + "," + Const.CERTIFICATE_AMOUNT +")"
                + "VALUES(?,?,?,?,?,?,?,?)";

        PreparedStatement prST = getDbConnection().prepareStatement(insert);
        prST.setString(1, number);
        prST.setString(2, series);
        prST.setString(3, institutionOfCertificate);
        prST.setString(4, reason);
        prST.setString(5, dateOfCertificate);
        prST.setString(6, workerName);
        prST.setString(7, workerSurname);
        prST.setString(8, daysOfIllness);


        prST.executeUpdate();
    }

    public ResultSet checkManager(Manager manager){
        ResultSet result;

        String select="SELECT * FROM "+Const.HUMAN_TABLE+" WHERE "+
                Const.HUMAN_LOGIN+"=? AND "+Const.HUMAN_PASSWORD+"=?";

        try {
            PreparedStatement prST = getDbConnection().prepareStatement(select);

            prST.setString(1, manager.getLogin());
            prST.setString(2, manager.getPassword());

            result=prST.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public ResultSet sortCertificates(){

        String select="SELECT * FROM "+Const.CERTIFICATE_TABLE;
        ResultSet result;

        try {

            PreparedStatement prST = getDbConnection().prepareStatement(select);

        result=prST.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
