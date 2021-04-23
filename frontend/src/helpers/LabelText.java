package helpers;

import javafx.scene.control.Label;

public class LabelText {
    private Label field;
    public LabelText(Label field){
        this.field = field;
    }

    public void unshift(String text) {
        field.setText(text + field.getText());
    }

    public void push(String text) {
        field.setText(field.getText() + text);
    }

    public void change(String text) {
        field.setText(text);
    }

    public void clear() {
        field.setText("");
    }
}
