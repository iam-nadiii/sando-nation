package com.sando_nation.screen;

import com.sando_nation.model.*;
import com.sando_nation.ui.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class OrderController {
    private Order order;
    private final Menu menu = new Menu();

    @FXML
    private Button cancelButton;

    public void initOrder(Order order) {
        this.order = order;
    }

    @FXML
    private void handleCancelOrder() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/sando_nation/home.fxml"));
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.setScene(new Scene(loader.load(), 600, 400));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAddSandwich() {
        System.out.println("Add sandwich — order #" + order.getOrderNumber());
    }

    @FXML
    private void handleAddDrink() {
        System.out.println("Add drink clicked");
    }

    @FXML
    private void handleAddChips() {
        System.out.println("Add chips clicked");
    }

    @FXML
    private void handleAddSignatureSandwich() {
        System.out.println("Add signature sandwich clicked");
    }

    @FXML
    private void handleCheckout() {
        System.out.println("Checkout clicked");
    }
}