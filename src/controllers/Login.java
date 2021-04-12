package controllers;

import animations.Shake;
import helpers.ChangeWindow;
import helpers.Validator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {

    @FXML
    private TextField loginField;

    @FXML
    private Label errorText;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signInButton;

    @FXML
    void click(ActionEvent event) {
        String error = checkFields();

        if (error.isEmpty()) {
            //TODO check login and password in server
            ChangeWindow changer = new ChangeWindow("/fxml/gradebook.fxml", signInButton);
            changer.hide();
            changer.load();
        }else errorText.setText(error);

    }

    private String checkFields() {
        Validator validator = new Validator();
        String loginText = loginField.getText().trim();
        String passwordText = passwordField.getText().trim();

        String LongLoginError = validator.maxStringLength(loginText, 50);
        String ShortLoginError = validator.minStringLength(loginText, 5);
        String EmptyLoginError = validator.checkEmpty(loginText);

        String LongPasswordError = validator.maxStringLength(passwordText, 50);
        String ShortPasswordError = validator.minStringLength(passwordText, 5);
        String EmptyPasswordError = validator.checkEmpty(passwordText);

        String error = "";

        if (!LongLoginError.isEmpty() || !ShortLoginError.isEmpty() || !EmptyLoginError.isEmpty()) {
            error = "Login error : " + LongLoginError + " " + ShortLoginError + " " + EmptyLoginError + "\n";
            Shake shakeLogin = new Shake(loginField);
            shakeLogin.startAnimation();
        }

        if (!LongPasswordError.isEmpty() || !ShortPasswordError.isEmpty() || !EmptyPasswordError.isEmpty()) {
            error += " Login error : " + LongPasswordError + " " + ShortPasswordError + " " + EmptyPasswordError;
            Shake shakePassword = new Shake(passwordField);
            shakePassword.startAnimation();
        }

        return error;
    }

}
