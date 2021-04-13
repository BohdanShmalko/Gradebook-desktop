package controllers.gradebook;

import helpers.tables.Mark;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Marks {

    @FXML
    private Label semestr;

    @FXML
    private Label years;

    @FXML
    private TableView<Mark> table;

    @FXML
    private TableColumn<Mark, Integer> number;

    @FXML
    private TableColumn<Mark, String> discipline;

    @FXML
    private TableColumn<Mark, Integer> hours;

    @FXML
    private TableColumn<Mark, Integer> credits;

    @FXML
    private TableColumn<Mark, String> teacher;

    @FXML
    private TableColumn<Mark, Integer> mark;

    @FXML
    private TableColumn<Mark, String> ects;

    @FXML
    private TableColumn<Mark, String> date;

    ObservableList<Mark> list = FXCollections.observableArrayList(
            //new Mark(1, 10, 21, 95, "some discipline", "some teacher", "exelent", "21.01.2021")
    );


    @FXML
    public void initialize() {

        //new LabelText(semestr).unshift("2021/2022");

        number.setCellValueFactory(new PropertyValueFactory<Mark, Integer>("number"));
        discipline.setCellValueFactory(new PropertyValueFactory<Mark, String>("discipline"));
        hours.setCellValueFactory(new PropertyValueFactory<Mark, Integer>("hours"));
        credits.setCellValueFactory(new PropertyValueFactory<Mark, Integer>("credits"));
        teacher.setCellValueFactory(new PropertyValueFactory<Mark, String>("teacher"));
        mark.setCellValueFactory(new PropertyValueFactory<Mark, Integer>("mark"));
        ects.setCellValueFactory(new PropertyValueFactory<Mark, String>("ects"));
        date.setCellValueFactory(new PropertyValueFactory<Mark, String>("date"));

        //list.add(new Mark(1, 10, 21, 95, "some discipline", "some teacher", "exelent", "21.01.2021"));
        table.setItems(list);
    }

}
