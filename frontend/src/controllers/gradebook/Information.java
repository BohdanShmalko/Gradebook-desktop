package controllers.gradebook;

import helpers.JSON;
import helpers.JsonDb;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class Information {

    @FXML
    private Label UniversityName;

    @FXML
    private Label GradebookNumber;

    @FXML
    private ImageView studentPhoto;

    @FXML
    private Label StudentName;

    @FXML
    private Label faculty;

    @FXML
    private Label trainingDirection;

    @FXML
    private Label specialty;

    @FXML
    private Label educationLevel;

    @FXML
    private Label educationForm;

    @FXML
    private Label course;

    @FXML
    private Label dateCourse;

    @FXML
    private Label proRector;

    @FXML
    private Label dean;

    @FXML
    private Label issueDate;

    public void initialize() {
        try {
            String token = (String) JSON.parse(JsonDb.get()).get("token");
            //TODO request to server
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}