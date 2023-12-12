package aquarium;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.util.HashMap;
import java.util.Map;

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
            fish.animate();
        }

    }

    protected static ComboBox<String> getComboBox() {
        ObservableList<String> colorOptions = FXCollections.observableArrayList();
        ComboBox<String> fishComboBox = new ComboBox<>(colorOptions);
        colorOptions.addAll(FishMap.getMap().keySet());
        fishComboBox.setValue(colorOptions.get(0));
        return fishComboBox;
    }

}
