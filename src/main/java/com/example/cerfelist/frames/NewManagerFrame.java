package com.example.cerfelist.frames;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

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


        DatabaseHandler dbHandler=new DatabaseHandler();
        addManagerButton.setOnAction(event->{
            try {
                dbHandler.signUpManager(newManagerNameText.getText(),newManagerSurnameText.getText(),
                        newManagerPositionText.getText(),newManagerLoginText.getText(),newManagerPasswordText.getText());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

}

