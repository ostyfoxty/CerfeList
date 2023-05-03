module com.example.cerfelist {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.cerfelist to javafx.fxml;
    exports com.example.cerfelist.frames;
    opens com.example.cerfelist.frames to javafx.fxml;
    exports com.example.cerfelist;
}