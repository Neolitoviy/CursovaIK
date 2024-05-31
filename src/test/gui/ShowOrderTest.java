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
class ShowOrderTest {

    @Start
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/gui/showOrder.fxml")));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @BeforeEach
    public void setUp() throws Exception {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(() -> new javafx.application.Application() {
            @Override
            public void start(Stage stage) throws IOException {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/gui/showOrder.fxml")));
                stage.setScene(new Scene(root));
                stage.show();
            }
        });
    }

    @Test
    void shouldContainLabelShowBouquets(FxRobot robot) {
        Label labelShowBouquets = robot.lookup("#labelShowBouquets").queryAs(Label.class);
        assertNotNull(labelShowBouquets);
        assertThat(labelShowBouquets.getText()).isEqualTo("Показати букети");
    }

    @Test
    void shouldContainBouquetListView(FxRobot robot) {
        ListView bouquetListView = robot.lookup("#bouquetListView").queryAs(ListView.class);
        assertNotNull(bouquetListView);
    }

    @Test
    void shouldContainBackToMainButton(FxRobot robot) {
        Button backToMainButton = robot.lookup("#backToMainButton").queryAs(Button.class);
        assertNotNull(backToMainButton);
        assertThat(backToMainButton.getText()).isEqualTo("Назад");
    }
}
