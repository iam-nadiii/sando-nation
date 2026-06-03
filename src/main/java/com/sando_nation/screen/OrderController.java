package com.sando_nation.screen;

import com.sando_nation.model.Menu;
import com.sando_nation.model.Order;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class OrderController {

    @FXML private Button cancelButton;
    @FXML private Label  orderLabel;
    @FXML private Label  orderSummary;

    private Order order;
    private final Menu menu = new Menu();

    public void initOrder(Order order) {
        this.order = order;
        orderLabel.setText("Order #" + order.getOrderNumber());
        orderSummary.setText("Items: " + order.getItems().size() +
                "  |  Total: $" + String.format("%.2f", order.getTotal()));
    }

    @FXML
    private void handleAddSandwich() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/sando_nation/sandwich.fxml"));
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.setScene(new Scene(loader.load(), 800, 600));
            SandwichController controller = loader.getController();
            controller.initOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAddDrink() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/sando_nation/drink.fxml"));
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.setScene(new Scene(loader.load(), 800, 600));
            DrinkController controller = loader.getController();
            controller.initOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAddChips() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/sando_nation/chips.fxml"));
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.setScene(new Scene(loader.load(), 800, 600));
            ChipsController controller = loader.getController();
            controller.initOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAddSignatureSandwich() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/sando_nation/signature.fxml"));
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.setScene(new Scene(loader.load(), 800, 600));
            SignatureController controller = loader.getController();
            controller.initOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleCheckout() {
        if (order.getItems().isEmpty()) {
            javafx.scene.control.Alert alert =
                    new javafx.scene.control.Alert(
                            javafx.scene.control.Alert.AlertType.WARNING);
            alert.setTitle("Empty Order");
            alert.setHeaderText(null);
            alert.setContentText("Please add items before checking out.");
            alert.showAndWait();
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/sando_nation/checkout.fxml"));
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.setScene(new Scene(loader.load(), 800, 600));
            CheckoutController controller = loader.getController();
            controller.initOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleCancelOrder() {
        navigateTo("home.fxml");
    }

    private void navigateTo(String fxml) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/sando_nation/" + fxml));
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.setScene(new Scene(loader.load(), 800, 600));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}