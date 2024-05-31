package test.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testfx.assertions.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
class AddFlowersTest {

    private Stage stage;

    @Start
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        loadFXMLAndShowStage("/gui/addFlowers.fxml");
    }

    @BeforeEach
    public void setUp() throws Exception {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(() -> new javafx.application.Application() {
            @Override
            public void start(Stage stage) throws IOException {
                loadFXMLAndShowStage("/gui/addFlowers.fxml");
            }
        });
    }

    private void loadFXMLAndShowStage(String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlPath)));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Test
    void shouldContainFlowerChoiceBox(FxRobot robot) {
        ChoiceBox<String> flowerChoiceBox = robot.lookup("#flowerChoiceBox").queryAs(ChoiceBox.class);
        assertNotNull(flowerChoiceBox);
    }

    @Test
    void shouldContainCountTextField(FxRobot robot) {
        TextField countTextField = robot.lookup("#count").queryAs(TextField.class);
        assertNotNull(countTextField);
        assertEquals("Введіть кількість квіток", countTextField.getPromptText());
    }

    @Test
    void shouldContainAddFlowersButton(FxRobot robot) {
        Button addFlowersButton = robot.lookup("#addFlowersButton").queryAs(Button.class);
        assertNotNull(addFlowersButton);
        assertThat(addFlowersButton).hasText("Додати");
    }

    @Test
    void shouldContainBackToBouquetButton(FxRobot robot) {
        Button backToBouquetButton = robot.lookup("#backToBouquetButton").queryAs(Button.class);
        assertNotNull(backToBouquetButton);
        assertThat(backToBouquetButton).hasText("Назад");
    }
}
