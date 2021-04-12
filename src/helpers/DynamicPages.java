package helpers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class DynamicPages {
    private String path;

    public DynamicPages(String path) {
        this.path = path;
    }

    public Parent loadPage() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(this.path));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();

        return root;
    }
}
