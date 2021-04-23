package controllers.gradebook;

import helpers.JSON;
import helpers.JsonDb;
import helpers.tables.Atestation;
import helpers.tables.Mark;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.json.simple.parser.ParseException;

public class Atestations {

    @FXML
    private TableView<Atestation> table;

    @FXML
    private TableColumn<Atestation, Integer> number;

    @FXML
    private TableColumn<Atestation, String> examName;

    @FXML
    private TableColumn<Atestation, String> date;

    ObservableList<Atestation> list = FXCollections.observableArrayList(
            //new Atestation()
    );

    @FXML
    public void initialize() {
        number.setCellValueFactory(new PropertyValueFactory<Atestation, Integer>("number"));
        examName.setCellValueFactory(new PropertyValueFactory<Atestation, String>("examName"));
        date.setCellValueFactory(new PropertyValueFactory<Atestation, String>("hours"));

        table.setItems(list);

        try {
            String token = (String) JSON.parse(JsonDb.get()).get("token");
            //TODO request to server
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}