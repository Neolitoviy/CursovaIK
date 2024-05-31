package test.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
class DeleteFlowerTest {

    private Stage stage;

    @Start
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        loadFXMLAndShowStage("/gui/deleteFlower.fxml");
    }

    @BeforeEach
    public void setUp() throws Exception {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(() -> new javafx.application.Application() {
            @Override
            public void start(Stage stage) throws IOException {
                loadFXMLAndShowStage("/gui/deleteFlower.fxml");
            }
        });
    }

    private void loadFXMLAndShowStage(String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlPath)));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Test
    void shouldContainFlowerListView(FxRobot robot) {
        ListView flowerListView = robot.lookup("#flowerListView").queryAs(ListView.class);
        assertNotNull(flowerListView);
    }

    @Test
    void shouldContainDeleteFlowerButton(FxRobot robot) {
        Button deleteFlowerButton = robot.lookup("#deleteFlowerButton").queryAs(Button.class);
        assertNotNull(deleteFlowerButton);
        assertThat(deleteFlowerButton).hasText("Видалити");
    }

    @Test
    void shouldContainBackToBouquetButton(FxRobot robot) {
        Button backToBouquetButton = robot.lookup("#backToBouquetButton").queryAs(Button.class);
        assertNotNull(backToBouquetButton);
        assertThat(backToBouquetButton).hasText("Назад");
    }

    @Test
    void shouldContainDeleteFlowerTitle(FxRobot robot) {
        Label deleteFlowerTitle = robot.lookup("#labelDeleteFlower").queryAs(Label.class);
        assertNotNull(deleteFlowerTitle);
        assertThat(deleteFlowerTitle).hasText("Виберіть квітку для видалення");
    }
}
