module register.system.MMXIX {
    requires javafx.fxml;
    requires javafx.controls;

    opens views to javafx.fxml;
    exports org.AHJ;
}