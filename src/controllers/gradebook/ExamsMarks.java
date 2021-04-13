package controllers.gradebook;

import helpers.tables.ExamMark;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ExamsMarks {

    @FXML
    private TableView<ExamMark> table;

    @FXML
    private TableColumn<ExamMark, Integer> mark;

    @FXML
    private TableColumn<ExamMark, String> ects;

    @FXML
    private TableColumn<ExamMark, String> commision;

    ObservableList<ExamMark> list = FXCollections.observableArrayList(
            //new Atestation()
    );

    @FXML
    public void initialize() {
        mark.setCellValueFactory(new PropertyValueFactory<ExamMark, Integer>("mark"));
        ects.setCellValueFactory(new PropertyValueFactory<ExamMark, String>("ects"));
        commision.setCellValueFactory(new PropertyValueFactory<ExamMark, String>("commision"));

        table.setItems(list);
    }

}