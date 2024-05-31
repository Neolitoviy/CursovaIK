package test.gui;

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
import gui.AppMainMenu;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.testfx.assertions.api.Assertions.assertThat;

@ExtendWith(ApplicationExtension.class)
class AppMainMenuTest {

    @Start
    public void start(Stage stage) throws Exception {
        new AppMainMenu().start(stage);
    }

    @BeforeEach
    public void setUp() throws Exception {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication(AppMainMenu.class);
    }

    @Test
    void shouldContainMainMenuText(FxRobot robot) {
        Text mainMenuText = robot.lookup(".main-menu-title").queryAs(Text.class);
        assertNotNull(mainMenuText);
        assertThat(mainMenuText).hasText("Головне Меню");
    }

    @Test
    void shouldContainAddBouquetButton(FxRobot robot) {
        Button addBouquetButton = robot.lookup("#addBouquet").queryAs(Button.class);
        assertNotNull(addBouquetButton);
        assertThat(addBouquetButton).hasText("Додати Букет");
    }

    @Test
    void shouldContainAddStandartBouquetButton(FxRobot robot) {
        Button addStandartBouquetButton = robot.lookup("#addStandartBouquetButton").queryAs(Button.class);
        assertNotNull(addStandartBouquetButton);
        assertThat(addStandartBouquetButton).hasText("Стандартні Букети");
    }

    @Test
    void shouldContainDeleteBouquetButton(FxRobot robot) {
        Button deleteBouquetButton = robot.lookup("#deleteBouquetButton").queryAs(Button.class);
        assertNotNull(deleteBouquetButton);
        assertThat(deleteBouquetButton).hasText("Видалити Букет");
    }

    @Test
    void shouldContainShowOrderButton(FxRobot robot) {
        Button showOrderButton = robot.lookup("#showOrder").queryAs(Button.class);
        assertNotNull(showOrderButton);
        assertThat(showOrderButton).hasText("Показати Замовлення");
    }

    @Test
    void shouldContainPayOrderButton(FxRobot robot) {
        Button payOrderButton = robot.lookup("#payOrderButton").queryAs(Button.class);
        assertNotNull(payOrderButton);
        assertThat(payOrderButton).hasText("Оплатити Замовлення");
    }

    @Test
    void shouldContainCancelOrderButton(FxRobot robot) {
        Button cancelOrderButton = robot.lookup("#cancelOrder").queryAs(Button.class);
        assertNotNull(cancelOrderButton);
        assertThat(cancelOrderButton).hasText("Скасувати Замовлення");
    }

    @Test
    void shouldContainExitButton(FxRobot robot) {
        Button exitButton = robot.lookup("#exit").queryAs(Button.class);
        assertNotNull(exitButton);
        assertThat(exitButton).hasText("Вихід");
    }
}