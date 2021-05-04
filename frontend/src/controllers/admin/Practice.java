package controllers.admin;

import helpers.Checker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

import java.time.format.DateTimeFormatter;

public class Practice {

    @FXML
    private Label studentError;

    @FXML
    private TextField precticeName;

    @FXML
    private Label practiceNameError;

    @FXML
    private Label courseError;

    @FXML
    private TextField place;

    @FXML
    private Label placeError;

    @FXML
    private TextField job;

    @FXML
    private Label jobError;

    @FXML
    private DatePicker from;

    @FXML
    private Label dateError;

    @FXML
    private DatePicker to;

    @FXML
    private Label teacherError;

    @FXML
    private TextField mark;

    @FXML
    private Label markError;

    @FXML
    private Label ects;

    @FXML
    private Button save;

    @FXML
    private Label good;

    @FXML
    private TextField student;

    @FXML
    private ComboBox<String> course;

    @FXML
    private TextField teacher;

    @FXML
    public void initialize() {
        initFields();

        save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean isHasError = checkPractice();

                if (!isHasError) {
                    successPractice();
                }
            }
        });
    }

    private void initFields() {
        ObservableList<String> courses = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6");
        course.setItems(courses);
    }

    private boolean checkPractice() {
        try {
            from.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            to.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            dateError.setText("");
        }catch (Throwable e){
            dateError.setText("Choose some date!");
        }

        return Checker.isAllEmpty(
                Checker.input(student, studentError, 255, 3),
                Checker.input(precticeName, practiceNameError, 255, 10),
                Checker.chooser(course, courseError),
                Checker.input(place, placeError, 255, 10),
                Checker.input(job, jobError, 255, 5),
                Checker.input(teacher, teacherError, 255, 3),
                Checker.input(mark, markError, 3, 1)
        );
    }

    private void successPractice() {
        //TODO send data to server
        Checker.temporarySuccess(good);
    }

}
