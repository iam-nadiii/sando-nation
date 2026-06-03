package com.sando_nation.screen;

import com.sando_nation.data.ReceiptFileHandler;
import com.sando_nation.model.Order;
import com.sando_nation.model.Receipt;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class CheckoutController {

    @FXML private Label    orderLabel;
    @FXML private TextArea orderSummary;
    @FXML private Label    totalLabel;
    @FXML private Button   cancelButton;

    private Order order;

    public void initOrder(Order order) {
        this.order = order;
        orderLabel.setText("Order #" + order.getOrderNumber());
        orderSummary.setText(order.toString());
        totalLabel.setText(String.format("Total: $%.2f", order.getTotal()));
    }

    @FXML
    private void handleConfirm() {
        Receipt receipt = new Receipt(LocalDateTime.now(), order);
        boolean success = ReceiptFileHandler.generateReceipt(receipt);

        if (success) {
            showAlert("Order confirmed! Thank you for choosing Sando-Nation!");
        } else {
            showAlert("Something went wrong generating your receipt. Please see staff.");
        }

        navigateTo("home.fxml");
    }

    @FXML
    private void handleCancel() {
        navigateTo("home.fxml");
    }

    private void showAlert(String message) {
        javafx.scene.control.Alert alert =
                new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle("Sando-Nation");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
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