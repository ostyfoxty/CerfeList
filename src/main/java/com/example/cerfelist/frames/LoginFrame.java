package com.example.cerfelist.frames;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.cerfelist.classes.Manager;
import com.example.cerfelist.sqlTools.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginFrame {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exitButton;

    @FXML
    private TextField loginText;

    @FXML
    private PasswordField passwordText;

    @FXML
    private Button registrationButton;

    @FXML
    private Button singInButton;

    @FXML
    void initialize() {

        singInButton.setOnAction(event->{
            String login= loginText.getText().trim();
            String password= passwordText.getText().trim();

            try {
                loginManager(login,password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        });

        registrationButton.setOnAction(event->{
            registrationButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/cerfelist/NewManagerFrame.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root=loader.getRoot();
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        exitButton.setOnAction(event->{
            exitButton.getScene().getWindow().hide();
        });


    }

    public void loginManager(String login,String password) throws SQLException {
        DatabaseHandler dbHandler=new DatabaseHandler();
        Manager manager =new Manager();
        manager.setLogin(login);
        manager.setPassword(password);


        ResultSet result=dbHandler.checkManager(manager);

        int counter=0;
        while(result.next()){
            counter++;
        }

        if(counter>=1){
            singInButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/cerfelist/NewCertificateFrame.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root=loader.getRoot();
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }
}
