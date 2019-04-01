module register.system.MMXIX {
    requires javafx.fxml;
    requires javafx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens views to javafx.fxml;
    exports org.AHJ;
}