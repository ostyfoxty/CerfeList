package com.example.cerfelist.frames;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
    private TextField seriesCertificateText;

    @FXML
    private TextField vacationsCertificateText;

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
    }

}
