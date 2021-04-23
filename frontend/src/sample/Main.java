package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        primaryStage.setTitle("Форма входу");
        primaryStage.setScene(new Scene(root, 300, 300));
        //primaryStage.setScene(new Scene(root, 1275, 660));
        //primaryStage.setMaximized(true);
        primaryStage.show();

        //String res = new Http("https://httpbin.org/").post("post", "");
        //System.out.println(res);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
