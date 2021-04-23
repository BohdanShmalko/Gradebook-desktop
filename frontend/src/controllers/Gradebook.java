package controllers;

import helpers.ChangeWindow;
import helpers.DynamicPages;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Pagination;
import javafx.scene.control.Button;
import javafx.util.Callback;

public class Gradebook {

    @FXML
    private Pagination main_paginator;

    @FXML
    private Button logout;

    @FXML
    void click(ActionEvent event) {
        //TODO delete session
        ChangeWindow changer = new ChangeWindow("/fxml/login.fxml", logout);
        changer.hide();
        changer.load();
    }

    @FXML
    public void initialize() {
        main_paginator.setPageFactory(new Callback<Integer, Node>() {
            private String[] allPages = {
                    "start", "information", "marks", "marks", "marks", "marks", "marks",
                    "marks", "marks", "marks", "marks", "marks", "marks", "marks", "marks",
                    "marks", "marks", "marks", "marks", "marks", "marks", "marks", "marks", "marks",
                    "marks", "marks", "practiceTable", "practice", "atestations", "examsMarks",
                    "degreeProject", "examinationCommission"
            };

            @Override
            public Node call(Integer param) {
                String pageName = allPages[param];
                String path = "/fxml/gradebook/" + pageName + ".fxml";
                return pageName == "marks" ?
                        new DynamicPages(path, param.toString()).loadPage() :
                        new DynamicPages(path).loadPage();
            }
        });
    }
}
