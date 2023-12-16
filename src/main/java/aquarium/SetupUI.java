package aquarium;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class SetupUI {

    protected static ComboBox<String> fishComboBox = getComboBox();
    public static StackPane getStackPane() {
        Background background = new Background(AquariumApp.appWidth, AquariumApp.appHeight);

        StackPane stackPane = new StackPane(background.imageView);

        HBox controlPanel = new HBox();
        controlPanel.setSpacing(10);

        controlPanel.getChildren().add(fishComboBox);
        controlPanel.getChildren().add(getButton());
        stackPane.getChildren().add(controlPanel);

        return stackPane;

    }
    protected static Button getButton() {
        Button addFishButton = new Button("Add Fish");
        addFishButton.setOnAction(event -> addFish(fishComboBox.getValue()));
        return addFishButton;
    }

    private static void addFish(String fishName) {
        Fish fish = FishFactory.createFish(fishName);
        if (fish != null) {
            fish.add();
        }

    }

    protected static ComboBox<String> getComboBox() {
        ObservableList<String> colorOptions = FXCollections.observableArrayList();
        ComboBox<String> fishComboBox = new ComboBox<>(colorOptions);
        colorOptions.addAll(FishMap.getMap().keySet());
        fishComboBox.setValue(colorOptions.getFirst());
        return fishComboBox;
    }

    public static Scene getScene(StackPane stackPane) {
        Scene scene = new Scene(stackPane, AquariumApp.appWidth, AquariumApp.appHeight);
        scene.setOnMouseClicked(event -> {
            try {
                Fish fish = FishFactory.createFish(fishComboBox.getValue());

                double x = event.getX() - ((double) AquariumApp.appWidth / 2);
                double y = event.getY() - ((double) AquariumApp.appHeight / 2);

                if (fish != null) {
                    fish.setStartPosition(x, y);
                    fish.add();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return scene;
    }

}
