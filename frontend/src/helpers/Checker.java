package helpers;

import animations.Shake;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class Checker {
    static public String chooser(ComboBox<String> box, Label label) {
        String text = box.getValue();
        String error = Validator.checkNull(text);
        ;

        if (!error.isEmpty()) {
            label.setText(error);
        } else {
            label.setText("");
        }
        return error;
    }

    static public String input(TextField input, Label label, int max, int min) {
        String text = input.getText();
        String error = "";
        error += Validator.checkEmpty(text);
        error += Validator.maxStringLength(text, max);
        error += Validator.minStringLength(text, min);

        if (!error.isEmpty()) {
            new Shake(input).startAnimation();
            label.setText(error);
        } else {
            label.setText("");
        }
        return error;
    }

    static public boolean isAllEmpty(String... args) {
        for (int i = 0; i < args.length; i++)
            if (!args[i].isEmpty()) return true;
        return false;
    }

    static public void temporarySuccess(Label label) {
        label.setText("✅");
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), ev -> {
            label.setText("");
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
