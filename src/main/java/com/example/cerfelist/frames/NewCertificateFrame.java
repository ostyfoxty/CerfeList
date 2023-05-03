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

public class NewCertificateFrame {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addCertificateButton;

    @FXML
    private TextField dateCertificateText;

    @FXML
    private Button exitNewCertificateButton;

    @FXML
    private TextField institutionCertificateText;

    @FXML
    private TextField numberCertificateText;

    @FXML
    private TextField reasonCertificateText;

    @FXML
    private Button reportButton;


    @FXML
    private TextField daysOfIllnesText;

    @FXML
    private TextField seriesCertificateText;

    @FXML
    private TextField workerNameText;

    @FXML
    private TextField workerSurnameText;

    @FXML
    void initialize() {

        reportButton.setOnAction(event->{
            reportButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/cerfelist/ReportFrame.fxml"));

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

        exitNewCertificateButton.setOnAction(event->{
            exitNewCertificateButton.getScene().getWindow().hide();
        });

        DatabaseHandler dbHandler=new DatabaseHandler();
        addCertificateButton.setOnAction(event->{
            try {
                dbHandler.addNewCertificate(numberCertificateText.getText(),seriesCertificateText.getText(),
                        institutionCertificateText.getText(),reasonCertificateText.getText(),dateCertificateText.getText(),
                        workerNameText.getText(),workerSurnameText.getText(),daysOfIllnesText.getText());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            addCertificateButton.getScene().getWindow().hide();

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

        });
    }

}
