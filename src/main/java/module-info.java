module reg_system {
    requires javafx.fxml;
    requires javafx.controls;
    requires opencsv;

    opens views to javafx.fxml;
    exports org.AHJ;
}