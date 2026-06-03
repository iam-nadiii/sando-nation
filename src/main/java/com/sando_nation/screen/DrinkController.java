package com.sando_nation.screen;

import com.sando_nation.model.Drink;
import com.sando_nation.model.Menu;
import com.sando_nation.model.Order;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class DrinkController {

    @FXML private ListView<String> drinkList;
    @FXML private ListView<String> sizeList;
    @FXML private Button           cancelButton;

    private final Menu menu = new Menu();
    private Order order;

    public void initOrder(Order order) {
        this.order = order;
        drinkList.setItems(FXCollections.observableArrayList(
                menu.getDrinks().stream().map(Drink::getName).toList()));
        drinkList.getSelectionModel().selectFirst();

        sizeList.setItems(FXCollections.observableArrayList(
                "Small", "Medium", "Large"));
        sizeList.getSelectionModel().selectFirst();
    }

    @FXML
    private void handleAddDrink() {
        int drinkIndex = drinkList.getSelectionModel().getSelectedIndex();
        int sizeIndex  = sizeList.getSelectionModel().getSelectedIndex();

        if (drinkIndex < 0 || sizeIndex < 0) return;

        Drink template = menu.getDrinks().get(drinkIndex);
        Drink selected = new Drink(template.getName(), template.getPriceSmall(),
                template.getPriceMedium(), template.getPriceLarge());

        switch (sizeIndex) {
            case 0 -> selected.setSize("small");
            case 1 -> selected.setSize("medium");
            case 2 -> selected.setSize("large");
        }

        order.addItem(selected);
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