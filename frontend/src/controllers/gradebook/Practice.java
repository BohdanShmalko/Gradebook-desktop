package controllers.gradebook;

import helpers.JSON;
import helpers.JsonDb;
import helpers.tables.PracticeUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.json.simple.parser.ParseException;

public class Practice {

    @FXML
    private TableView<PracticeUnit> table;

    @FXML
    private TableColumn<PracticeUnit, String> from;

    @FXML
    private TableColumn<PracticeUnit, String> to;

    @FXML
    private TableColumn<PracticeUnit, String> teachers;

    @FXML
    private TableColumn<PracticeUnit, Integer> mark;

    @FXML
    private TableColumn<PracticeUnit, String> ects;

    @FXML
    private TableColumn<PracticeUnit, String> date;

    ObservableList<PracticeUnit> list = FXCollections.observableArrayList(
            //new Atestation()
    );

    @FXML
    public void initialize() {
        from.setCellValueFactory(new PropertyValueFactory<PracticeUnit, String>("from"));
        to.setCellValueFactory(new PropertyValueFactory<PracticeUnit, String>("to"));
        teachers.setCellValueFactory(new PropertyValueFactory<PracticeUnit, String>("teachers"));
        mark.setCellValueFactory(new PropertyValueFactory<PracticeUnit, Integer>("mark"));
        ects.setCellValueFactory(new PropertyValueFactory<PracticeUnit, String>("ects"));
        date.setCellValueFactory(new PropertyValueFactory<PracticeUnit, String>("date"));

        table.setItems(list);

        try {
            String token = (String) JSON.parse(JsonDb.get()).get("token");
            //TODO request to server
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}