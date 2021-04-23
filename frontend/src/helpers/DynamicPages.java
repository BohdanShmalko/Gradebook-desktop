package helpers;

import controllers.gradebook.Marks;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class DynamicPages {
    String path, data = "";

    public DynamicPages(String path) {
        this.path = path;
    }

    public DynamicPages(String path, String data) {
        this.path = path;
        this.data = data;
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

        if(!data.isEmpty()) {
            Marks controller =
                    loader.<Marks>getController();
            controller.initData(data);
        }

        return root;
    }
}
