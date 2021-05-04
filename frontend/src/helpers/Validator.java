package helpers;

import animations.Shake;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;

public class Validator {
    static public String maxStringLength(String str, int length) {
        if (str.length() > length) return "The text is very long! ";
        return "";
    }

    static public String minStringLength(String str, int length) {
        if (str.length() < length) return "The text is very short! ";
        return "";
    }

    static public String checkNull(String str) {
        if (str == null) return "Choose something! ";
        return "";
    }

    static public String checkEmpty(String str) {
        if (str.isEmpty()) return "Enter something! ";
        return "";
    }
}
