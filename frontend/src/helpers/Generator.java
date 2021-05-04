package helpers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.Random;

public class Generator {
    static public String generate(int length) {
        String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String result = "";
        for (int i = 0; i < length; i++) {
            result += symbols.charAt(new Random().nextInt(symbols.length()));
        }
        return result;
    }

    static public void generatorForButton(Button btn, TextField tf) {
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tf.setText(Generator.generate(20));
            }
        });
    }
}
