package test.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import static org.testfx.assertions.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
class PayOrderTest {

    private Stage stage;

    @Start
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        loadFXMLAndShowStage("/gui/payOrder.fxml");
    }

    @BeforeEach
    public void setUp() throws Exception {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(() -> new javafx.application.Application() {
            @Override
            public void start(Stage stage) throws IOException {
                loadFXMLAndShowStage("/gui/payOrder.fxml");
            }
        });
    }

    private void loadFXMLAndShowStage(String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxmlPath)));
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Test
    void shouldContainCardNumberTextField(FxRobot robot) {
        TextField cardNumberField = robot.lookup("#cardNumber").queryAs(TextField.class);
        assertNotNull(cardNumberField);
        assertThat(cardNumberField.getPromptText()).isEqualTo("Введіть номер вашої картки");
    }

    @Test
    void shouldContainPayOrderButton(FxRobot robot) {
        Button payOrderButton = robot.lookup("#payOrderButton").queryAs(Button.class);
        assertNotNull(payOrderButton);
        assertThat(payOrderButton.getText()).isEqualTo("Оплатити");
    }

    @Test
    void shouldContainBackToMainButton(FxRobot robot) {
        Button backToMainButton = robot.lookup("#backToMainButton").queryAs(Button.class);
        assertNotNull(backToMainButton);
        assertThat(backToMainButton.getText()).isEqualTo("Назад");
    }

    @Test
    void shouldContainLabelPayOrder(FxRobot robot) {
        Label labelPayOrder = robot.lookup("#labelPayOrder").queryAs(Label.class);
        assertNotNull(labelPayOrder);
        assertThat(labelPayOrder.getText()).isEqualTo("Оплата замовлення");
    }
}
