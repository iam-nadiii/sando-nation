package com.sando_nation.screen;

import com.sando_nation.model.Chips;
import com.sando_nation.model.Menu;
import com.sando_nation.model.Order;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ChipsController {

    @FXML private ListView<String> chipsList;
    @FXML private Button           cancelButton;

    private final Menu menu = new Menu();
    private Order order;

    public void initOrder(Order order) {
        this.order = order;
        chipsList.setItems(FXCollections.observableArrayList(
                menu.getChips().stream().map(Chips::getName).toList()));
        chipsList.getSelectionModel().selectFirst();
    }

    @FXML
    private void handleAddChips() {
        int selected = chipsList.getSelectionModel().getSelectedIndex();
        if (selected < 0) return;

        order.addItem(menu.getChips().get(selected));
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