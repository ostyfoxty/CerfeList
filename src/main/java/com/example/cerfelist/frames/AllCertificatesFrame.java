package com.example.cerfelist.frames;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.cerfelist.classes.Certificate;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class AllCertificatesFrame {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<Certificate> allCertificatesList;

    @FXML
    private Button cancelAllCertificatesButton;

    @FXML
    private Button exitAllCertificatesButton;

    @FXML
    void initialize() {
        exitAllCertificatesButton.setOnAction(event->{
            exitAllCertificatesButton.getScene().getWindow().hide();
        });

        cancelAllCertificatesButton.setOnAction(event->{
            cancelAllCertificatesButton.getScene().getWindow().hide();

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
