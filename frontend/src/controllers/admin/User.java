package controllers.admin;

import animations.Shake;
import helpers.Checker;
import helpers.Generator;
import helpers.Validator;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class User {

    @FXML
    private TextField studentLoginInput;

    @FXML
    private Button generateStudentLogin;

    @FXML
    private Label studentLoginError;

    @FXML
    private Label studentPasswordError;

    @FXML
    private TextField studentPasswordInput;

    @FXML
    private Button generateStudentPassword;

    @FXML
    private TextField studentName;

    @FXML
    private Label studentNameError;

    @FXML
    private TextField gradebookNumber;

    @FXML
    private Label gradebookError;

    @FXML
    private ComboBox<String> chooseGroup;

    @FXML
    private Label chooseGroupError;

    @FXML
    private ComboBox<String> chooseCourse;

    @FXML
    private Label courseError;

    @FXML
    private Button addPhoto;

    @FXML
    private ImageView photo;
    private File photoFile;

    @FXML
    private Button createStudent;

    @FXML
    private Label goodStudent;

    @FXML
    private TextField adminLoginInput;

    @FXML
    private Button generateAdminLogin;

    @FXML
    private Label adminLoginError;

    @FXML
    private Label adminPasswordError;

    @FXML
    private TextField adminPasswordInput;

    @FXML
    private Button generateAdminPassword;

    @FXML
    private TextField adminName;

    @FXML
    private Label adminNameError;

    @FXML
    private Button createAdmin;

    @FXML
    private Label adminGood;

    @FXML
    private TextField groupNameInput;

    @FXML
    private Label groupNameError;

    @FXML
    private TextField cafedraInput;

    @FXML
    private Label cafedraError;

    @FXML
    private Label chooseSpecialityError;

    @FXML
    private ComboBox<String> chooseSpeciality;

    @FXML
    private TextField trainingDirectionInput;

    @FXML
    private Label trainingDirectionError;

    @FXML
    private TextField educationalLevelInput;

    @FXML
    private Label educationallevelError;

    @FXML
    private TextField educationFormInput;

    @FXML
    private Label educationFormError;

    @FXML
    private Button createGroup;

    @FXML
    private Label goodCreateGroup;

    @FXML
    private TextField teacherLastName;

    @FXML
    private Label teacherLastNameError;

    @FXML
    private TextField fatherName;

    @FXML
    private Label fatherNameError;

    @FXML
    private TextField teacherName;

    @FXML
    private Label teacherNameError;

    @FXML
    private Button createTeacher;

    @FXML
    private Label goodTeacher;

    @FXML
    public void initialize() {
        initFields();

        createStudent.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean isHasError = checkStudent();

                if (!isHasError) {
                    successStudent();
                }
            }
        });

        createAdmin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean isHasError = checkAdmin();

                if (!isHasError) {
                    successAdmin();
                }
            }
        });

        createTeacher.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean isHasError = checkTeacher();

                if (!isHasError) {
                    successTeacher();
                }
            }
        });

        createGroup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                boolean isHasError = checkGroup();

                if (!isHasError) {
                    successGroup();
                }
            }
        });

        addPhoto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                chooseImage();
            }
        });

        Generator.generatorForButton(generateStudentLogin, studentLoginInput);
        Generator.generatorForButton(generateStudentPassword, studentPasswordInput);
        Generator.generatorForButton(generateAdminLogin, adminLoginInput);
        Generator.generatorForButton(generateAdminPassword, adminPasswordInput);
    }

    private void chooseImage() {
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
        fc.getExtensionFilters().add(imageFilter);
        File file = fc.showOpenDialog(null);

        if (file != null) {
            try {
                photoFile = file;
                photo.setImage(new Image(new FileInputStream(photoFile.getAbsoluteFile())));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void initFields() {
        //TODO load all groups names
        ObservableList<String> groups = FXCollections.observableArrayList("Java", "JavaScript", "C#", "Python");
        chooseGroup.setItems(groups);

        ObservableList<String> courses = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6");
        chooseCourse.setItems(courses);

        //TODO load all specialities names
        ObservableList<String> specialities = FXCollections.observableArrayList("121", "126", "123");
        chooseSpeciality.setItems(specialities);

        Image image = new Image(getClass().getResourceAsStream("/resource/defaultUser.png"));
        photo.setImage(image);
    }

    private boolean checkAdmin() {
        return Checker.isAllEmpty(
                Checker.input(adminLoginInput, adminLoginError, 30, 5),
                Checker.input(adminPasswordInput, adminPasswordError, 30, 5),
                Checker.input(adminName, adminNameError, 255, 3)
        );
    }

    private void successAdmin() {
        //TODO send data to server and check
        Checker.temporarySuccess(adminGood);
    }

    private boolean checkTeacher() {
        return Checker.isAllEmpty(
                Checker.input(teacherLastName, teacherLastNameError, 30, 3),
                Checker.input(teacherName, teacherNameError, 30, 3),
                Checker.input(fatherName, fatherNameError, 30, 3)
        );
    }

    private void successTeacher() {
        //TODO send data to server and check
        Checker.temporarySuccess(goodTeacher);
    }

    private boolean checkGroup() {
        return Checker.isAllEmpty(
                Checker.input(groupNameInput, groupNameError, 10, 2),
                Checker.input(cafedraInput, cafedraError, 100, 2),
                Checker.chooser(chooseSpeciality, chooseSpecialityError),
                Checker.input(trainingDirectionInput, trainingDirectionError, 100, 3),
                Checker.input(educationalLevelInput, educationallevelError, 100, 3),
                Checker.input(educationFormInput, educationFormError, 100, 3)
        );
    }

    private void successGroup() {
        //TODO send data to server and check
        Checker.temporarySuccess(goodCreateGroup);
    }

    private boolean checkStudent() {
        return Checker.isAllEmpty(
                Checker.input(studentLoginInput, studentLoginError, 30, 5),
                Checker.input(studentPasswordInput, studentPasswordError, 30, 5),
                Checker.input(studentName, studentNameError, 255, 0),
                Checker.input(gradebookNumber, gradebookError, 30, 5),
                Checker.chooser(chooseGroup, chooseGroupError),
                Checker.chooser(chooseCourse, courseError)
        );
    }

    private void successStudent() {
        //TODO send data to server
        Checker.temporarySuccess(goodStudent);
    }
}
