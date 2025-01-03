package dad.calendario;

import dad.calendario.customcomponent.MonthCalendar;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalendarApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(new MonthCalendar());

        stage.setTitle("Calendario");
        stage.setScene(scene);
        stage.show();
    }
}
