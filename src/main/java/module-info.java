module com.example.finalprojectjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.desktop;

    opens com.example.finalprojectjavafx to javafx.fxml;
    exports com.example.finalprojectjavafx;
}