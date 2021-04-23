package controllers.gradebook;

import helpers.JSON;
import helpers.JsonDb;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.json.simple.parser.ParseException;

public class ExaminationCommission {

    @FXML
    private Label decision;

    @FXML
    private Label head;

    @FXML
    private Label members;

    @FXML
    private Label date;

    @FXML
    private Label studentName;

    @FXML
    private Label number;

    @FXML
    private Label issueDate;

    @FXML
    private Label issuer;

    @FXML
    private Label dean;

    public void initialize() {
        try {
            String token = (String) JSON.parse(JsonDb.get()).get("token");
            //TODO request to server
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}