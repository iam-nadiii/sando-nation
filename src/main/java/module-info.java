module com.sando_nation {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.sando_nation.screen to javafx.fxml;
    exports com.sando_nation.screen;
}