package controllers;

import helpers.DynamicPages;
import helpers.LabelText;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class Marks {

    @FXML
    private AnchorPane mainPane;

    @FXML
    private Button users;

    @FXML
    private Button marks;

    @FXML
    private Button practice;

    @FXML
    private Button atestations;

    @FXML
    private Button degree;

    @FXML
    private Label wellcome;

    @FXML
    public void initialize() {
        //TODO get admin name from server
        new LabelText(wellcome).push("Some name");

        users.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent page = new DynamicPages("/fxml/admin/User.fxml").loadPage();
                mainPane.getChildren().setAll(page);
            }
        });

        marks.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent page = new DynamicPages("/fxml/admin/Marks.fxml").loadPage();
                mainPane.getChildren().setAll(page);
            }
        });

        practice.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent page = new DynamicPages("/fxml/admin/Practice.fxml").loadPage();
                mainPane.getChildren().setAll(page);
            }
        });

        atestations.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent page = new DynamicPages("/fxml/admin/Atestations.fxml").loadPage();
                mainPane.getChildren().setAll(page);
            }
        });

        degree.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent page = new DynamicPages("/fxml/admin/DegreeProject.fxml").loadPage();
                mainPane.getChildren().setAll(page);
            }
        });
    }

}
