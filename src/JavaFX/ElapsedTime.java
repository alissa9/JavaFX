/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFX;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

/**
 *
 * @author Issa
 */
public class ElapsedTime {

    /*Elapsed time box which implemnted the same way with the clock field and so on for all the other field*/
    Pane ElapsedTimeContainer() {
        StackPane pane = new StackPane();
        GridPane grid = new GridPane();

        Label title = new Label("Elapsed Time");
         /*Moving the title to the top corner of the box*/
        title.setTranslateX(8);
        title.setTranslateY(-8);
        StackPane.setAlignment(title, Pos.TOP_LEFT);
        grid.setStyle("-fx-border-color: white;"
                + "-fx-border-radius:10;");
        title.setStyle("-fx-background-color: #654321;"
                + "-fx-text-fill: white;");
          
        title.setFont(Font.font("verdana", FontWeight.BOLD, 12));
        pane.getChildren().addAll(grid, title);
        pane.getChildren().add(ContainerElapsedTime());
        return pane;
    }
    /*Elapsed Timer variables*/
    Label elapsedTimer = new Label();
    Timeline timeline;
    int hours = 0, mins = 0, seconds = 0;


    /*Converting the seconds into minutes and minutes to hours */
    void change(Label elapsedTimer) {

        if (seconds == 60) {
            mins++;
            seconds = 0;
        }
        if (mins == 60) {
            hours++;
            mins = 0;
        }
        
        elapsedTimer.setText(
                (((hours / 10) == 0) ? "0" : "") + hours + ":"
                + (((mins / 10) == 0) ? "0" : "") + mins + ":"
                + (((seconds / 10) == 0) ? "0" : "") + seconds++);

    }

    /*The container of the elapsed box in HBox to lay them next to each other which contains the timer digits and buttons*/
    Pane ContainerElapsedTime() {
        HBox pane = new HBox();

        HBox timerDigits = new HBox();
        VBox timerPane = new VBox(3);
        TimerBtn start = new TimerBtn("START", 65, 40);
        TimerBtn stop = new TimerBtn("STOP", 65, 40);
        TimerBtn reset = new TimerBtn("RESET", 65, 40);

        elapsedTimer = new Label("00:00:00");

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), (ActionEvent event) -> {
            change(elapsedTimer);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);

        /*Start timer method when clicked the timer will start*/
        start.setOnAction(e -> {
            timeline.play();
        });

        /*Stop timer method when clicked the timer will pause*/
        stop.setOnAction(e -> {
            timeline.pause();
        });

        /*Reset timer method when clicked the timer will Reset timer to 0 */
        reset.setOnAction(e -> {
            hours = 0;
            mins = 0;
            seconds = 0;
            timeline.pause();
            elapsedTimer.setText("00:00:00");
        });

        elapsedTimer.setPadding(new Insets(50, 25, 50, 25));
        timerDigits.setSpacing(50);
        elapsedTimer.setTextFill(Color.RED);
        elapsedTimer.setStyle("-fx-font: 90 arial;");
        timerDigits.getChildren().addAll(elapsedTimer);

        pane.getChildren().add(timerDigits);

        timerPane.setSpacing(5);
        timerPane.setPadding(new Insets(20, 10, 20, 10));
        timerPane.setAlignment(Pos.CENTER);
        timerPane.getChildren().addAll(start, stop, reset);
        pane.getChildren().add(timerPane);
        return pane;

    }

}
