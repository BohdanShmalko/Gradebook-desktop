package controllers.gradebook;

import helpers.tables.PracticeField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PracticeTable {

    @FXML
    private TableView<PracticeField> table;

    @FXML
    private TableColumn<PracticeField, Integer> number;

    @FXML
    private TableColumn<PracticeField, String> practiceName;

    @FXML
    private TableColumn<PracticeField, Integer> course;

    @FXML
    private TableColumn<PracticeField, String> place;

    @FXML
    private TableColumn<PracticeField, String> work;

    ObservableList<PracticeField> list = FXCollections.observableArrayList(
            //new Atestation()
    );

    @FXML
    public void initialize() {
        number.setCellValueFactory(new PropertyValueFactory<PracticeField, Integer>("number"));
        practiceName.setCellValueFactory(new PropertyValueFactory<PracticeField, String>("practiceName"));
        course.setCellValueFactory(new PropertyValueFactory<PracticeField, Integer>("course"));
        place.setCellValueFactory(new PropertyValueFactory<PracticeField, String>("place"));
        work.setCellValueFactory(new PropertyValueFactory<PracticeField, String>("work"));

        table.setItems(list);
    }

}