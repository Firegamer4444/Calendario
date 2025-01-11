package dad.calendario;

import dad.calendario.controllers.RootController;
import dad.calendario.customcomponent.MonthCalendar;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class CalendarApp extends Application {

    RootController rootController = new RootController();
    private final Image icon = new Image(String.valueOf(getClass().getResource("/images/calendar-64x64.png")));

    @Override
    public void start(Stage stage) throws Exception {

        Scene scene = new Scene(rootController.getRoot());

        stage.setMinHeight(400);
        stage.setMinWidth(600);
        stage.setTitle("Calendario");
        stage.getIcons().setAll(icon);
        stage.setScene(scene);
        stage.show();
    }
}
