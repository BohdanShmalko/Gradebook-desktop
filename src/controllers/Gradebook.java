package controllers;

import helpers.DynamicPages;
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
    private Button logOutButton;

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
                Parent page;
                page = new DynamicPages(path).loadPage();
                return page;
            }
        });

        logOutButton.setOnAction(event -> {
            System.out.println("logOut");
        });
    }

}
