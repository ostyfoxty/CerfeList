package com.example.cerfelist.frames;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.cerfelist.sqlTools.DatabaseHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SortingDateFrame {

    public static String sortDate;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cancelDateSortingButton;

    @FXML
    private TextField dateSortingText;

    @FXML
    private Button okDateSortingButton;

    @FXML
    void initialize() {
        cancelDateSortingButton.setOnAction(event->{
            cancelDateSortingButton.getScene().getWindow().hide();

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

        okDateSortingButton.setOnAction(event->{

            sortDate=dateSortingText.getText();

            okDateSortingButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/com/example/cerfelist/AllCertificatesFrame.fxml"));

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
