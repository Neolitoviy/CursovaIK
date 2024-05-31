package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import main.accessories.Accessory;
import main.bouquets.Bouquet;
import main.flowers.Flower;
import main.flowers.Rose;
import main.order.Order;
import main.utils.BouquetUtils;
import main.utils.OrderUtils;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {
    static Order order = new Order();
    static Bouquet bouquet = new Bouquet();

    //    public Button addBouquet;
//    public Button addBowButton;
//    public Button addFoilButton;
//    public Button addStripButton;
//    public Button backToBouquetButton;
//    public Button addFlowersButton;
//    public Button addStandartBouquetButton;
//    public Button deleteBouquetButton;
//    public Button showOrder;
//    public Button payOrderButton;
//    public Button cancelOrder;
//    public Button addAccessoryButton;
//    public Button deleteFlowerButton;
//    public Button deleteAccessoryButton;
//    public Button showFlowersButton;
//    public Button showAccessoriesButton;
//    public Button backToMainFromBouquetButton;
//    public Label labelShowBouquets;
//    public Button backToMainButton;
//    public Label labelDeleteFlower;
//    public Label labelPayOrder;
//    public Label labelShowAccessories;
//    public Label labelShowFlowers;
//    public Label labelAddStandardBouquet;
//    public Button addStandardBouquetButton;
//    public Button exit;
    private Parent root;
    private Stage stage;
    private Scene scene;
    public void addBouquet(ActionEvent e) throws IOException {
        MainMenuController.bouquet = new Bouquet();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("bouquetMenu.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private ChoiceBox<String> bouquetChoiceBox = new ChoiceBox<>();
    private final String[] bouquetsStandart = {"100 and 1 rose", "night stars"};
    public void addStandartBouquetButton(ActionEvent e) throws IOException{
        MainMenuController.bouquet = new Bouquet();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("standartBouquet.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void addStandarBouquet(ActionEvent e) {
        switch (bouquetChoiceBox.getValue()){
            case "100 and 1 rose" -> {
                BouquetUtils.addFlowersToBouquet(MainMenuController.bouquet, "redrose", 100);
                BouquetUtils.addFlowersToBouquet(MainMenuController.bouquet, "whiterose", 1);
            }
            case "night stars" -> {
                BouquetUtils.addFlowersToBouquet(MainMenuController.bouquet, "blacktulip", 100);
                BouquetUtils.addFlowersToBouquet(MainMenuController.bouquet, "yellowtulip", 1);
            }
            default -> {
                BouquetUtils.addFlowersToBouquet(MainMenuController.bouquet, "yellowtulip", 0);
            }
        }
    }
    public void deleteBouquetButton(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("deleteBouquet.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private ListView<Bouquet> bouquetListView = new ListView<>();
    public void deleteBouquet(ActionEvent e){
        int selectedIndx = bouquetListView.getSelectionModel().getSelectedIndex();
        bouquetListView.getItems().remove(selectedIndx);
        order.getBouquets().remove(selectedIndx);
    }
    public void showOrder(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("showOrder.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void payOrderButton(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("payOrder.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private TextField cardNumber = new TextField();
    public void payOrder(ActionEvent e){
        order.setCardNumber(cardNumber.getText());
        OrderUtils.saveCheck(order);
        OrderUtils.saveOrder(order);
        OrderUtils.cancelOrder(order);
    }
    public void cancelOrder(ActionEvent e) {
        OrderUtils.cancelOrder(order);
    }
    public void exit(ActionEvent e) {
        System.exit(0);
    }
    public void backToMain(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AppMainMenu.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    //  ADD FLOWERS
    @FXML
    private ChoiceBox<String> flowerChoiceBox = new ChoiceBox<>();
    @FXML
    private TextField count = new TextField();
    private final String[] flowers = {"redrose", "whiterose", "yellowtulip", "blacktulip"};
    public void addFlowersButton(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("addFlowers.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void addFlowers(ActionEvent e){
        BouquetUtils.addFlowersToBouquet(MainMenuController.bouquet, flowerChoiceBox.getValue(), Integer.parseInt(count.getText()));
    }
    public void backToBouquet(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("bouquetMenu.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    //  ADD ACCESSORY
    @FXML
    private ChoiceBox<String> colorChoiceBox = new ChoiceBox<>();
    private final String[] colors= {"red", "white", "silver", "gold"};
    public void addAccessoryButton(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("addAccessory.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void addBow(ActionEvent e){
        BouquetUtils.addAccessoryToBouquet(MainMenuController.bouquet, "bow", colorChoiceBox.getValue());
    }
    public void addStrip(ActionEvent e){
        BouquetUtils.addAccessoryToBouquet(MainMenuController.bouquet, "strip", colorChoiceBox.getValue());
    }
    public void addFoil(ActionEvent e){
        BouquetUtils.addAccessoryToBouquet(MainMenuController.bouquet, "foil", colorChoiceBox.getValue());
    }
    //  SHOW FLOWERS
    @FXML
    private ListView<Flower> flowerListView = new ListView<>();
    public void showFlowersButton(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("showFlowers.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    //  SHOW ACCESSORIES
    @FXML
    private ListView<Accessory> accessoriesListView = new ListView<>();
    public void showAccessoriesButton(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("showAccessories.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    // DELETE FLOWER
    public void deleteFlowerButton(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("deleteFlower.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void deleteFlower(){
        int selectedIndx = flowerListView.getSelectionModel().getSelectedIndex();
        flowerListView.getItems().remove(selectedIndx);
        bouquet.getFlowers().remove(selectedIndx);
    }
    // DELETE ACCESSORY
    public void deleteAccessoryButton(ActionEvent e) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("deleteAccessory.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void deleteAccessory(){
        int selectedIndx = accessoriesListView.getSelectionModel().getSelectedIndex();
        accessoriesListView.getItems().remove(selectedIndx);
        bouquet.getAccessories().remove(selectedIndx);
    }
    public void backToMainFromBouquet(ActionEvent e) throws IOException {
        MainMenuController.order.addBouquet(MainMenuController.bouquet);
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AppMainMenu.fxml")));
        stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bouquetChoiceBox.getItems().addAll(bouquetsStandart);
        flowerChoiceBox.getItems().addAll(flowers);
        colorChoiceBox.getItems().addAll(colors);
        flowerListView.getItems().addAll(bouquet.getFlowers());
        accessoriesListView.getItems().addAll(bouquet.getAccessories());
        bouquetListView.getItems().addAll(order.getBouquets());
    }
}