/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFX;

import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Issa
 */
public class ClockTime {

    /*Each field is implemnted using the stack and grid pane to initialise the title border 
      then have the title on the top of the border using the grid and set style methods */
    Pane ClockTimeContainer() {
        StackPane pane = new StackPane();
        GridPane grid = new GridPane();
        Label title = new Label("Day Time Clock");
        /*Moving the title to the top corner of the box*/
        title.setTranslateX(8);
        title.setTranslateY(-8);
        StackPane.setAlignment(title, Pos.TOP_LEFT);
        grid.setStyle("-fx-border-color: white;"
                + "-fx-border-radius:10;");
        title.setStyle("-fx-background-color: #654321;"
                + "-fx-text-fill: white;");

        title.setFont(Font.font("verdana", FontWeight.BOLD, 12));

        grid.setPadding(new Insets(25, 5, 25, 5));
        pane.getChildren().addAll(grid, title);

        /*A label to display the time then declaring a thread to keep it running on the GUI,
        defining the date format ,the thread will always update the time but to ensure that time will change 
        on every second I put a thread to sleep for (1 milliseconds) after that it will initialize 
        the time string and update constantly to the label of clock */
        Label clockTime = new Label();
        Thread timerThread = new Thread(() -> {

            /*Also if I wanted to Display the calenedar date then simply
            by giving the full date foramt("yyyy/MM/dd HH:mm:ss");*/
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
                String time = dateFormat.format(new Date());
                Platform.runLater(() -> {
                    clockTime.setText(time);
                });
            }
        });
        /*Starting the thread*/
        timerThread.start();

        clockTime.setPadding(new Insets(50, 25, 50, 25));
        clockTime.setTextFill(Color.GREEN);
        clockTime.setStyle("-fx-font: 90 arial;");

        StackPane.setAlignment(clockTime, Pos.TOP_LEFT);
        pane.getChildren().add(clockTime);

        return pane;

    }

}
