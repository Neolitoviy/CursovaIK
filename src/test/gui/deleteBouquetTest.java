package test.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
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
class DeleteBougetsTest {

    private Stage stage;

    @Start
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        loadFXMLAndShowStage("/gui/deleteBouquet.fxml");
    }

    @BeforeEach
    public void setUp() throws Exception {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(() -> new javafx.application.Application() {
            @Override
            public void start(Stage stage) throws IOException {
                loadFXMLAndShowStage("/gui/deleteBouquet.fxml");
            }
        });
    }

    private void loadFXMLAndShowStage(String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlPath)));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Test
    void shouldContainBouquetListView(FxRobot robot) {
        ListView bouquetListView = robot.lookup("#bouquetListView").queryAs(ListView.class);
        assertNotNull(bouquetListView);
    }

    @Test
    void shouldContainDeleteBouquetButton(FxRobot robot) {
        Button deleteBouquetButton = robot.lookup("#deleteBouquetButton").queryAs(Button.class);
        assertNotNull(deleteBouquetButton);
        assertThat(deleteBouquetButton).hasText("Видалити");
    }

    @Test
    void shouldContainBackToMainButton(FxRobot robot) {
        Button backToMainButton = robot.lookup("#backToMainButton").queryAs(Button.class);
        assertNotNull(backToMainButton);
        assertThat(backToMainButton).hasText("Назад");
    }

    @Test
    void shouldContainMainMenuTitle(FxRobot robot) {
        Label mainMenuTitle = robot.lookup("#labelShowBouquets").queryAs(Label.class);
        assertNotNull(mainMenuTitle);
        assertThat(mainMenuTitle).hasText("Показати букети");
    }
}
