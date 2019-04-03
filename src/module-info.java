module reg_system {
    requires javafx.fxml;
    requires javafx.controls;

    opens views to javafx.fxml;
    exports org.AHJ;
}