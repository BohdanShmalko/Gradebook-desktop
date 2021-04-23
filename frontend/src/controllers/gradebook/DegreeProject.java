package controllers.gradebook;

import helpers.JSON;
import helpers.JsonDb;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.json.simple.parser.ParseException;

public class DegreeProject {

    @FXML
    private Label studentName;

    @FXML
    private Label topic;

    @FXML
    private Label supervisor;

    @FXML
    private Label submissionDate;

    @FXML
    private Label protectionDate;

    @FXML
    private Label mark;

    @FXML
    private Label ects;

    @FXML
    private Label commision;

    public void initialize() {
        try {
            String token = (String) JSON.parse(JsonDb.get()).get("token");
            //TODO request to server
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}