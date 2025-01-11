package dad.calendario.customcomponent;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.ResourceBundle;

public class MonthCalendar extends GridPane implements Initializable {


    // model

    IntegerProperty year = new SimpleIntegerProperty(0);
    IntegerProperty month = new SimpleIntegerProperty(1);


    // view

    @FXML
    private Label monthLabel;

    public MonthCalendar(){
        super();
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/monthCalendarView.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // bindings

        monthLabel.textProperty().bind(Bindings.createStringBinding(() -> {
           return LocalDate.of(year.get() , month.get() , 1).getMonth().getDisplayName(TextStyle.FULL ,new Locale( "es" , "ES" )).toLowerCase();
        } , month));

        for (int i = 8; i < getChildren().size(); i++){
            Label label = (Label) getChildren().get(i);

            label.textProperty().bind(Bindings.createStringBinding(() -> {
                LocalDate localDate = LocalDate.of(year.get(), month.get(), 1);
                int firstDayOfMonth = localDate.getDayOfWeek().getValue();
                if (firstDayOfMonth > getChildren().indexOf(label) - 7 | (getChildren().indexOf(label) - firstDayOfMonth - 6) > localDate.lengthOfMonth()){
                    return "";
                }
                return "" + (getChildren().indexOf(label) - firstDayOfMonth - 6);
            } , year , month));
        }

    }

    // getters and setters


    public int getYear() {
        return year.get();
    }

    public IntegerProperty yearProperty() {
        return year;
    }

    public void setYear(int year) {
        this.year.set(year);
    }

    public int getMonth() {
        return month.get();
    }

    public IntegerProperty monthProperty() {
        return month;
    }

    public void setMonth(int month) {
        this.month.set(month);
    }
}
