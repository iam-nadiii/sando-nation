module com.sando_nation {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.sando_nation.screen to javafx.fxml;
    exports com.sando_nation.screen;

    opens com.sando_nation.model to javafx.fxml;
    exports com.sando_nation.model;

    opens com.sando_nation.data to javafx.fxml;
    exports com.sando_nation.data;

    opens com.sando_nation.ui to javafx.fxml;
    exports com.sando_nation.ui;
}