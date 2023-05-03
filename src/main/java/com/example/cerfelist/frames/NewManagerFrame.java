package com.example.cerfelist.frames;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.example.cerfelist.classes.Manager;
import com.example.cerfelist.sqlTools.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewManagerFrame {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addManagerButton;

    @FXML
    private Button cancelAddManagerButton;

    @FXML
    private Button exitAddManagerButton;

    @FXML
    private TextField newManagerLoginText;

    @FXML
    private TextField newManagerNameText;

    @FXML
    private TextField newManagerPasswordText;

    @FXML
    private TextField newManagerPositionText;

    @FXML
    private TextField newManagerSurnameText;

    @FXML
    void initialize() {
        cancelAddManagerButton.setOnAction(event->{
            cancelAddManagerButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/cerfelist/LoginFrame.fxml"));

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

        exitAddManagerButton.setOnAction(event-> exitAddManagerButton.getScene().getWindow().hide());


        addManagerButton.setOnAction(event->{

            getDataForSignUpNewManager();

            addManagerButton.getScene().getWindow().hide();

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
    }

    public void getDataForSignUpNewManager(){

        DatabaseHandler dbHandler=new DatabaseHandler();

        try {
            String name = newManagerNameText.getText();
            String surname = newManagerSurnameText.getText();
            String position = newManagerPositionText.getText();
            String login = newManagerLoginText.getText();
            String password= newManagerPasswordText.getText();

            Manager manager=new Manager(name,surname,
                    position,login,password);

            dbHandler.signUpManager(manager);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

