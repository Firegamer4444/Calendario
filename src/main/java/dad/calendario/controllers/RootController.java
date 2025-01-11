package dad.calendario.controllers;

import dad.calendario.customcomponent.MonthCalendar;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    // model

    IntegerProperty year = new SimpleIntegerProperty(2025);

    // view

    @FXML
    private GridPane root;

    @FXML
    private MonthCalendar abrilCalendar;

    @FXML
    private MonthCalendar agostoCalendar;

    @FXML
    private MonthCalendar diciembreCalendar;

    @FXML
    private MonthCalendar eneroCalendar;

    @FXML
    private MonthCalendar febreroCalendar;

    @FXML
    private MonthCalendar julioCalendar;

    @FXML
    private MonthCalendar junioCalendar;

    @FXML
    private MonthCalendar marzoCalendar;

    @FXML
    private MonthCalendar mayoCalendar;

    @FXML
    private MonthCalendar noviembreCalendar;

    @FXML
    private MonthCalendar octubreCalendar;

    @FXML
    private MonthCalendar septiembreCalendar;

    @FXML
    private Label yearLabel;

    public RootController(){
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/rootView.fxml"));
            loader.setController(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // bindings

        yearLabel.textProperty().bindBidirectional(year , new NumberStringConverter("#"));

        eneroCalendar.yearProperty().bind(year);
        febreroCalendar.yearProperty().bind(year);
        marzoCalendar.yearProperty().bind(year);
        abrilCalendar.yearProperty().bind(year);
        mayoCalendar.yearProperty().bind(year);
        junioCalendar.yearProperty().bind(year);
        julioCalendar.yearProperty().bind(year);
        agostoCalendar.yearProperty().bind(year);
        septiembreCalendar.yearProperty().bind(year);
        octubreCalendar.yearProperty().bind(year);
        noviembreCalendar.yearProperty().bind(year);
        diciembreCalendar.yearProperty().bind(year);

    }

    @FXML
    void onDecreaseYearAction(ActionEvent event) {
        year.set(year.get() - 1);
    }

    @FXML
    void onIncreaseYearAction(ActionEvent event) {
        year.set(year.get() + 1);
    }

    // getters and setters

    public GridPane getRoot() {
        return root;
    }
}
