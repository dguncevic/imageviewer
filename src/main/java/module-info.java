module com.imageviewer {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.imageviewer to javafx.fxml;
    exports com.imageviewer;
}
