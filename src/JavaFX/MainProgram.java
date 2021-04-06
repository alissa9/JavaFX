package JavaFX;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


/**
 *
 * @author Mohamad Ikbal Alissa M00714688
 *
 */

/*A Surgery Control Panel implemnted using javaFX and methods representing clocks, 
  TemperatureControl, humidity and pressure additionally light control and medical gases 
  All the areas on the screen consists of nodes, buttons, labels, text, images and shapes*/
public class MainProgram extends Application {

    @Override
    public void start(Stage primaryStage) {
        /*creating the scene with a width and height*/
        Scene scene = new Scene(getBorderLayout(), 955, 725);
        primaryStage.setTitle("Surgery Control Panel");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    /*The MainProgram layer is the border pane because it has a settting for top, left, centre, 
    right and bottom which helps to have each field layed out on the screen*/
    Pane getBorderLayout() {

        /*Calling the class and accessing the function of it */
        TemperatureControl Temp = new TemperatureControl();
        HumidityControl Humid = new HumidityControl();
        PressureControl Pressure = new PressureControl();

        BorderPane pane = new BorderPane();
        pane.setBackground(new Background(new BackgroundFill(Color.valueOf("rgb(101,67,33)"), new CornerRadii(0), Insets.EMPTY)));
        pane.setTop(getHBoxTop());
        pane.setLeft(Temp.Temperature());
        pane.setCenter(Humid.HumidityControl());
        pane.setRight(Pressure.PressureControl());
        pane.setBottom(getHBoxBottom());

        return pane;
    }

    /*The Hbox is for the top because it has two fields Clock and Elapsed and to seprate them horizontally */
    Pane getHBoxTop() {
        HBox pane = new HBox();

        ClockTime Clock = new ClockTime();
        ElapsedTime Elapsed = new ElapsedTime();
        pane.setPadding(new Insets(25, 25, 25, 25));
        pane.getChildren().add(Clock.ClockTimeContainer());
        pane.setSpacing(15);
        pane.getChildren().add(Elapsed.ElapsedTimeContainer());

        return pane;
    }

    /*Start of bottom boxes */
    Pane getHBoxBottom() {
        HBox pane = new HBox();

        LightControl Light = new LightControl();
        MedicalGases Medical = new MedicalGases();
        pane.setPadding(new Insets(25, 25, 25, 25));
        pane.getChildren().add(Light.LightControlContainer());
        pane.setSpacing(15);
        pane.getChildren().add(Medical.MedicalGases());

        return pane;
    }

}
