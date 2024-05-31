package test.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
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
class BouquetMenuTest {

    private Stage stage;

    @Start
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        loadFXMLAndShowStage("/gui/bouquetMenu.fxml");
    }

    @BeforeEach
    public void setUp() throws Exception {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(() -> new javafx.application.Application() {
            @Override
            public void start(Stage stage) throws IOException {
                loadFXMLAndShowStage("/gui/bouquetMenu.fxml");
            }
        });
    }

    private void loadFXMLAndShowStage(String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlPath)));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Test
    void shouldContainMenuBouquetText(FxRobot robot) {
        Text menuBouquetText = robot.lookup(".main-menu-title").queryAs(Text.class);
        assertNotNull(menuBouquetText);
        assertThat(menuBouquetText).hasText("Меню Букету");
    }

    @Test
    void shouldContainAddFlowersButton(FxRobot robot) {
        Button addFlowersButton = robot.lookup("#addFlowersButton").queryAs(Button.class);
        assertNotNull(addFlowersButton);
        assertThat(addFlowersButton).hasText("Додати Квіти");
    }

    @Test
    void shouldContainAddAccessoryButton(FxRobot robot) {
        Button addAccessoryButton = robot.lookup("#addAccessoryButton").queryAs(Button.class);
        assertNotNull(addAccessoryButton);
        assertThat(addAccessoryButton).hasText("Додати Аксесуар");
    }

    @Test
    void shouldContainDeleteFlowerButton(FxRobot robot) {
        Button deleteFlowerButton = robot.lookup("#deleteFlowerButton").queryAs(Button.class);
        assertNotNull(deleteFlowerButton);
        assertThat(deleteFlowerButton).hasText("Видалити Квіти");
    }

    @Test
    void shouldContainDeleteAccessoryButton(FxRobot robot) {
        Button deleteAccessoryButton = robot.lookup("#deleteAccessoryButton").queryAs(Button.class);
        assertNotNull(deleteAccessoryButton);
        assertThat(deleteAccessoryButton).hasText("Видалити Аксесуар");
    }

    @Test
    void shouldContainShowFlowersButton(FxRobot robot) {
        Button showFlowersButton = robot.lookup("#showFlowersButton").queryAs(Button.class);
        assertNotNull(showFlowersButton);
        assertThat(showFlowersButton).hasText("Показати Квіти");
    }

    @Test
    void shouldContainShowAccessoriesButton(FxRobot robot) {
        Button showAccessoriesButton = robot.lookup("#showAccessoriesButton").queryAs(Button.class);
        assertNotNull(showAccessoriesButton);
        assertThat(showAccessoriesButton).hasText("Показати Аксесуари");
    }

    @Test
    void shouldContainBackToMainFromBouquetButton(FxRobot robot) {
        Button backToMainFromBouquetButton = robot.lookup("#backToMainFromBouquetButton").queryAs(Button.class);
        assertNotNull(backToMainFromBouquetButton);
        assertThat(backToMainFromBouquetButton).hasText("Назад");
    }
}
