module com.example.javafxanddatabase{
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    exports com.example.javafxanddatabase;
    opens com.example.javafxanddatabase to javafx.fxml;
    exports com.example.javafxanddatabase.dataBase;
    opens com.example.javafxanddatabase.dataBase to javafx.fxml;
}