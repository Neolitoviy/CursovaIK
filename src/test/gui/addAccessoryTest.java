package test.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.io.IOException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.testfx.assertions.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
class AddAccessoryTest {

    private Stage stage;

    @Start
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        loadFXMLAndShowStage("/gui/addAccessory.fxml");
    }

    @BeforeEach
    public void setUp() throws Exception {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(() -> new javafx.application.Application() {
            @Override
            public void start(Stage stage) throws IOException {
                loadFXMLAndShowStage("/gui/addAccessory.fxml");
            }
        });
    }

    private void loadFXMLAndShowStage(String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlPath)));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Test
    void shouldContainColorChoiceBox(FxRobot robot) {
        ChoiceBox<String> colorChoiceBox = robot.lookup("#colorChoiceBox").queryAs(ChoiceBox.class);
        assertNotNull(colorChoiceBox);
    }

    @Test
    void shouldContainAddBowButton(FxRobot robot) {
        Button addBowButton = robot.lookup("#addBowButton").queryAs(Button.class);
        assertNotNull(addBowButton);
        assertThat(addBowButton).hasText("Додати бантик");
    }

    @Test
    void shouldContainAddFoilButton(FxRobot robot) {
        Button addFoilButton = robot.lookup("#addFoilButton").queryAs(Button.class);
        assertNotNull(addFoilButton);
        assertThat(addFoilButton).hasText("Додати фольгу");
    }

    @Test
    void shouldContainAddStripButton(FxRobot robot) {
        Button addStripButton = robot.lookup("#addStripButton").queryAs(Button.class);
        assertNotNull(addStripButton);
        assertThat(addStripButton).hasText("Додати стрічку");
    }

    @Test
    void shouldContainBackToBouquetButton(FxRobot robot) {
        Button backToBouquetButton = robot.lookup("#backToBouquetButton").queryAs(Button.class);
        assertNotNull(backToBouquetButton);
        assertThat(backToBouquetButton).hasText("Назад");
    }
}
