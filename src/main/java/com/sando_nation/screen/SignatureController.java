package com.sando_nation.screen;

import com.sando_nation.model.Menu;
import com.sando_nation.model.Order;
import com.sando_nation.model.SandwichSize;
import com.sando_nation.model.SignatureSandwich;
import com.sando_nation.model.RegularTopping;
import com.sando_nation.model.Sauce;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.ArrayList;

public class SignatureController {

    @FXML private ListView<String> signatureList;
    @FXML private ListView<String> sizeList;
    @FXML private Label            summaryLabel;
    @FXML private Button           cancelButton;

    private final Menu menu = new Menu();
    private Order order;

    public void initOrder(Order order) {
        this.order = order;

        signatureList.setItems(FXCollections.observableArrayList(
                menu.getSignatureSandwiches().stream()
                        .map(SignatureSandwich::getSignatureName)
                        .toList()));
        signatureList.getSelectionModel().selectFirst();

        sizeList.setItems(FXCollections.observableArrayList(
                menu.getSizes().stream()
                        .map(SandwichSize::getDescription)
                        .toList()));
        sizeList.getSelectionModel().selectFirst();

        // show summary when selection changes
        signatureList.getSelectionModel().selectedIndexProperty()
                .addListener((obs, oldVal, newVal) -> updateSummary(newVal.intValue()));

        updateSummary(0);
    }

    private void updateSummary(int index) {
        if (index < 0 || index >= menu.getSignatureSandwiches().size()) return;
        SignatureSandwich s = menu.getSignatureSandwiches().get(index);

        String toppings = s.getRegularToppings().stream()
                .map(RegularTopping::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("None");

        String sauces = s.getSauces().stream()
                .map(Sauce::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("None");

        summaryLabel.setText(
                "Bread: " + s.getBread().getName() +
                        " | Meat: " + s.getMeat().getName() +
                        " | Cheese: " + s.getCheese().getName() +
                        " | Toppings: " + toppings +
                        " | Sauce: " + sauces +
                        " | Toasted: " + (s.isToasted() ? "Yes" : "No"));
    }

    @FXML
    private void handleAddSignature() {
        int sigIndex  = signatureList.getSelectionModel().getSelectedIndex();
        int sizeIndex = sizeList.getSelectionModel().getSelectedIndex();

        if (sigIndex < 0 || sizeIndex < 0) return;

        SignatureSandwich selected = menu.getSignatureSandwiches().get(sigIndex);
        SandwichSize size = menu.getSizes().get(sizeIndex);

        SignatureSandwich copy = new SignatureSandwich(
                selected.getSignatureName(),
                selected.getBread(),
                selected.getMeat(),
                selected.getCheese(),
                selected.isToasted()
        );
        copy.setSandwichSize(size);
        copy.initializeToppings(new ArrayList<>(selected.getRegularToppings()));
        copy.initializeSauces(new ArrayList<>(selected.getSauces()));

        order.addItem(copy);
        navigateToOrder();
    }

    @FXML
    private void handleCancel() {
        navigateToOrder();
    }

    private void navigateToOrder() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/sando_nation/order.fxml"));
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.setScene(new Scene(loader.load(), 800, 600));
            OrderController controller = loader.getController();
            controller.initOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}