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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


public class ReportFrame {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ToggleGroup SortingGroup;
    @FXML
    private Button cancelReportButton;

    @FXML
    private Button okButton;
    @FXML
    private RadioButton sortingDateButton;

    @FXML
    private RadioButton sortingShowAllButton;

    @FXML
    private RadioButton sortingWorkerButton;

    public static int dec =0;


    @FXML
    void initialize() {

        cancelReportButton.setOnAction(event->{
            cancelReportButton.getScene().getWindow().hide();

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

        okButton.setOnAction(event->{
            okButton.getScene().getWindow().hide();

           FXMLLoader loader = new FXMLLoader();

          if(sortingShowAllButton.isSelected()) {
               loader.setLocation(getClass().getResource("/com/example/cerfelist/AllCertificatesFrame.fxml"));
               dec=1;
           }else if(sortingWorkerButton.isSelected()){
               loader.setLocation(getClass().getResource("/com/example/cerfelist/SortingWorkerFrame.fxml"));
               dec =2;
           }else
               loader.setLocation(getClass().getResource("/com/example/cerfelist/SortingDateFrame.fxml"));
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
