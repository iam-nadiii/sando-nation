package com.sando_nation.screen;

import com.sando_nation.model.Order;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomeController {

    @FXML private Button newOrderButton;
    @FXML private Button exitButton;

    @FXML
    private void handleNewOrder() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/sando_nation/order.fxml"));
            Stage stage = (Stage) newOrderButton.getScene().getWindow();
            stage.setScene(new Scene(loader.load(), 800, 600));

            OrderController controller = loader.getController();
            int orderNumber = (int)(Math.random() * 9000) + 1000;
            controller.initOrder(new Order(orderNumber));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }
}