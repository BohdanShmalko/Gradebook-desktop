package controllers;

import helpers.DynamicPages;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Pagination;
import javafx.util.Callback;

public class Gradebook {

    @FXML
    private Pagination main_paginator;

    @FXML
    public void initialize() {
        main_paginator.setPageFactory(new Callback<Integer, Node>() {
            private String[] allPages = {
                    "start", "information", "exam", "credit", "exam", "credit", "exam",
                    "credit", "exam", "credit", "exam", "credit", "exam", "credit", "exam",
                    "credit", "practice1", "practice2", "certification1", "certification2",
                    "degreeProject", "examinationCommission"
            };

            @Override
            public Node call(Integer param) {
                String path = "/fxml/gradebook/" + allPages[param];
                Parent page = new DynamicPages(path).loadPage();
                page.setId(param.toString());
                return page;
            }
        });
    }

}
