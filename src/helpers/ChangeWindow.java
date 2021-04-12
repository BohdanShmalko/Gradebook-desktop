package helpers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangeWindow {
    private String location = "";
    private Node node;

    public ChangeWindow (String location) {
        this.location = location;
    }

    public ChangeWindow (String location, Node node) {
        this.location = location;
        this.node = node;
    }
    public void hide() {
        this.node.getScene().getWindow().hide();
    }

    public void load() {
        Parent root = new DynamicPages(this.location).loadPage();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}
