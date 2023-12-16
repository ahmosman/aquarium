package aquarium;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class AquariumApp extends Application {

    public static final int appWidth = 1000;
    public static final int appHeight = 1000;

    public static StackPane stackPane;
    @Override
    public void start(Stage stage) {

        stackPane = SetupUI.getStackPane();

        Scene scene = SetupUI.getScene(stackPane);

        // Set the stage to not display the window decorations (title bar, etc.)
//        stage.initStyle(StageStyle.UNDECORATED);

        stage.setTitle("Aquarium App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }


}
