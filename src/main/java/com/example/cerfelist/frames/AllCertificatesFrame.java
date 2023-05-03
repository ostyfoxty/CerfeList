package com.example.cerfelist.frames;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.cerfelist.sqlTools.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import static com.example.cerfelist.frames.ReportFrame.dec;

public class AllCertificatesFrame {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> allCertificatesList;

    @FXML
    private Button cancelAllCertificatesButton;

    @FXML
    private Button exitAllCertificatesButton;

   // public static DatabaseHandler dbHand=new DatabaseHandler();


    @FXML
    void initialize() {

        try {
            show();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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

    public void show() throws SQLException {

        ArrayList<String> arr = new ArrayList<>();
        DatabaseHandler dbHandler=new DatabaseHandler();

        ResultSet result=dbHandler.sortCertificates();

        try{
            if(dec==1) {
                while (result.next()) {
                    arr.add(result.getString("Number") + "\t" + result.getString("Series")
                            + "\t" + result.getString("InstitutionOfCertificate") + "\t" + result.getString("Reason")
                            + "\t" + result.getString("DateOfCertificate") + "\t" + result.getString("WorkerName")
                            + "\t" + result.getString("WorkerSurname") + "\t" + result.getString("DaysOfIllness"));
                }
            }else if(dec==2){
                while (result.next()) {
                    if(result.getString("WorkerName").equals(SortingWorkerFrame.sortName) && result.getString("WorkerSurname").equals(SortingWorkerFrame.sortSurname))
                    arr.add(result.getString("Number") + "\t" + result.getString("Series")
                            + "\t" + result.getString("InstitutionOfCertificate") + "\t" + result.getString("Reason")
                            + "\t" + result.getString("DateOfCertificate") + "\t" + result.getString("WorkerName")
                            + "\t" + result.getString("WorkerSurname") + "\t" + result.getString("DaysOfIllness"));
                }
            }else {
                while (result.next()) {
                    if(result.getString("DateOfCertificate").equals(SortingDateFrame.sortDate))
                        arr.add(result.getString("Number") + "\t" + result.getString("Series")
                                + "\t" + result.getString("InstitutionOfCertificate") + "\t" + result.getString("Reason")
                                + "\t" + result.getString("DateOfCertificate") + "\t" + result.getString("WorkerName")
                                + "\t" + result.getString("WorkerSurname") + "\t" + result.getString("DaysOfIllness"));
                }
            }

        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        ObservableList<String> list = FXCollections.observableArrayList(arr);
        allCertificatesList.setItems(list);
    }

    }


