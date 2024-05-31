package test.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
class StandartBouquetTest {

    @Start
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/gui/standartBouquet.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @BeforeEach
    public void setUp() throws Exception {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(() -> new javafx.application.Application() {
            @Override
            public void start(Stage stage) throws IOException {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/gui/standartBouquet.fxml")));
                stage.setScene(new Scene(root));
                stage.show();
            }
        });
    }

    @Test
    void shouldContainLabelAddStandardBouquet(FxRobot robot) {
        Label labelAddStandardBouquet = robot.lookup("#labelAddStandardBouquet").queryAs(Label.class);
        assertNotNull(labelAddStandardBouquet);
        assertThat(labelAddStandardBouquet.getText()).isEqualTo("Виберіть букет для додавання");
    }

    @Test
    void shouldContainBouquetChoiceBox(FxRobot robot) {
        ChoiceBox bouquetChoiceBox = robot.lookup("#bouquetChoiceBox").queryAs(ChoiceBox.class);
        assertNotNull(bouquetChoiceBox);
    }

    @Test
    void shouldContainAddStandardBouquetButton(FxRobot robot) {
        Button addStandardBouquetButton = robot.lookup("#addStandardBouquetButton").queryAs(Button.class);
        assertNotNull(addStandardBouquetButton);
        assertThat(addStandardBouquetButton.getText()).isEqualTo("Додати");
    }

    @Test
    void shouldContainBackToMainFromBouquetButton(FxRobot robot) {
        Button backToMainFromBouquetButton = robot.lookup("#backToMainFromBouquetButton").queryAs(Button.class);
        assertNotNull(backToMainFromBouquetButton);
        assertThat(backToMainFromBouquetButton.getText()).isEqualTo("Назад");
    }
}
