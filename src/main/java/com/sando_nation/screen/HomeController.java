package com.sando_nation.screen;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HomeController {

    @FXML
    private Button newOrderButton;

    @FXML
    private Button exitButton;

    @FXML
    private void handleNewOrder() {
        System.out.println("New order clicked"); // wire up later
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }
}