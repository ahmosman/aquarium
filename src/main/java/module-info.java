module com.aquarium.aquarium {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.almasb.fxgl.all;

    opens aquarium to javafx.fxml;
    exports aquarium;
}