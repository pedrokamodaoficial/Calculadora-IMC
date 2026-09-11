module com.kamoda.analisecurricular {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.kamoda.analisecurricular to javafx.fxml;
    exports com.kamoda.analisecurricular;
}