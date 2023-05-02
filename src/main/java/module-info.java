module com.example.cerfelist {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cerfelist to javafx.fxml;
    exports com.example.cerfelist;
}