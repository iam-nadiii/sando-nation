package com.sando_nation.screen;

import com.sando_nation.model.Bread;
import com.sando_nation.model.Cheese;
import com.sando_nation.model.Meat;
import com.sando_nation.model.Menu;
import com.sando_nation.model.Order;
import com.sando_nation.model.Sandwich;
import com.sando_nation.model.SandwichSize;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.List;

public class SandwichController {

    @FXML private Label          stepLabel;
    @FXML private Label          sandwichSummary;
    @FXML private ListView<String> optionsList;
    @FXML private CheckBox       extraCheckBox;
    @FXML private Button         nextButton;
    @FXML private Button         doneButton;
    @FXML private Button         cancelButton;

    private final Menu     menu     = new Menu();
    private final Sandwich sandwich = new Sandwich();
    private Order          order;
    private int            step     = 1;

    public void initOrder(Order order) {
        this.order = order;
        showStep(step);
    }

    private void showStep(int step) {
        extraCheckBox.setVisible(false);
        doneButton.setVisible(false);

        switch (step) {
            case 1 -> {
                stepLabel.setText("Step 1 — Select a size");
                nextButton.setText("Next");
                populateList(menu.getSizes().stream()
                        .map(SandwichSize::getDescription)
                        .toList());
            }
            case 2 -> {
                stepLabel.setText("Step 2 — Select your bread");
                nextButton.setText("Next");
                populateList(menu.getBreads().stream()
                        .map(Bread::getName)
                        .toList());
            }
            case 3 -> {
                stepLabel.setText("Step 3 — Select your meat");
                extraCheckBox.setVisible(true);
                nextButton.setText("Next");
                populateList(menu.getMeats().stream()
                        .map(Meat::getName)
                        .toList());
            }
            case 4 -> {
                stepLabel.setText("Step 4 — Select your cheese");
                extraCheckBox.setVisible(true);
                nextButton.setText("Next");
                populateList(menu.getCheeses().stream()
                        .map(Cheese::getName)
                        .toList());
            }
            case 5 -> {
                stepLabel.setText("Step 5 — Remove toppings you don't want");
                sandwich.initializeToppings(menu.getToppings());
                nextButton.setText("Remove Selected");
                doneButton.setVisible(true);
                populateList(sandwich.getRegularToppings().stream()
                        .map(rt -> rt.getName())
                        .toList());
            }
            case 6 -> {
                stepLabel.setText("Step 6 — Remove sauces you don't want");
                sandwich.initializeSauces(menu.getSauces());
                nextButton.setText("Remove Selected");
                doneButton.setVisible(true);
                populateList(sandwich.getSauces().stream()
                        .map(s -> s.getName())
                        .toList());
            }
            case 7 -> {
                stepLabel.setText("Step 7 — Toasted?");
                nextButton.setText("Finish");
                populateList(List.of("Yes", "No"));
            }
        }
        updateSummary();
    }

    private void populateList(List<String> items) {
        optionsList.setItems(FXCollections.observableArrayList(items));
        optionsList.getSelectionModel().selectFirst();
    }

    private void updateSummary() {
        sandwichSummary.setText(sandwich.toString()
                .replace("\n", " | ")
                .trim());
    }

    @FXML
    private void handleNext() {
        int selected = optionsList.getSelectionModel().getSelectedIndex();

        switch (step) {
            case 1 -> sandwich.setSandwichSize(menu.getSizes().get(selected));
            case 2 -> sandwich.setBread(menu.getBreads().get(selected));
            case 3 -> {
                Meat meat = menu.getMeats().get(selected);
                meat.setWantsExtra(extraCheckBox.isSelected());
                sandwich.setMeat(meat);
            }
            case 4 -> {
                Cheese cheese = menu.getCheeses().get(selected);
                cheese.setWantsExtra(extraCheckBox.isSelected());
                sandwich.setCheese(cheese);
            }
            case 5 -> {
                if (selected >= 0 && !sandwich.getRegularToppings().isEmpty()) {
                    sandwich.removeTopping(sandwich.getRegularToppings().get(selected));
                    populateList(sandwich.getRegularToppings().stream()
                            .map(rt -> rt.getName())
                            .toList());
                    updateSummary();
                }
                return; // stay on step 5
            }
            case 6 -> {
                if (selected >= 0 && !sandwich.getSauces().isEmpty()) {
                    sandwich.removeSauce(sandwich.getSauces().get(selected));
                    populateList(sandwich.getSauces().stream()
                            .map(s -> s.getName())
                            .toList());
                    updateSummary();
                }
                return; // stay on step 6
            }
            case 7 -> {
                sandwich.setToasted(selected == 0);
                finishSandwich();
                return;
            }
        }

        step++;
        showStep(step);
    }

    @FXML
    private void handleDone() {
        step++;
        doneButton.setVisible(false);
        nextButton.setText("Next");
        showStep(step);
    }

    private void finishSandwich() {
        order.addItem(sandwich);
        navigateTo("order.fxml", order);
    }

    @FXML
    private void handleCancel() {
        navigateTo("order.fxml", order);
    }


    private void navigateTo(String fxml, Order order) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/com/sando_nation/" + fxml));
            System.out.println("Loading: " + fxml);
            System.out.println("Order items: " + order.getItems().size());
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.setScene(new Scene(loader.load(), 800, 600));
            OrderController controller = loader.getController();
            System.out.println("Controller: " + controller);
            controller.initOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}