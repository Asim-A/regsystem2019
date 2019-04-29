module reg_system {
    requires javafx.fxml;
    requires javafx.controls;
    requires opencsv;
    requires com.jfoenix;
    requires java.desktop;

    opens views to javafx.fxml;
    exports org.AHJ;
}