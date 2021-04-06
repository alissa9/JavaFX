/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFX;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Issa
 */
public class LightControl {

    /*Inserting the colors combinations into an array to print them out when
      pressing the increasing and decreasing buttons,
      each row has a counter so that it will not interrupt the other rows */
    int[] rgbRedAndGreen = {102, 153, 204, 255, 255, 255};
    int[] rgbBlue = {0, 0, 0, 0, 153, 204};
    int rgbCounterRow1 = 0;
    int rgbCounterRow2 = 0;
    int rgbCounterRow3 = 0;

    Pane LightControlContainer() {
        StackPane pane = new StackPane();
        GridPane grid = new GridPane();
        Label title = new Label("Light Control");
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

        grid.setPadding(new Insets(25, 25, 25, 25));

        pane.getChildren().add(containerLightControl());

        return pane;

    }

    /*The container for the Light Control 
    to get them aligned by making a VBox then 
    Hbox for each row to have them placed horizontally*/
    Pane containerLightControl() {
        VBox pane = new VBox();
        pane.setPadding(new Insets(1, 35, 1, 35));
        pane.getChildren().add(lightFristRow());
        pane.getChildren().add(lightSecondRow());
        pane.getChildren().add(lightThirdRow());
        return pane;
    }

    /*The frist Hbox which contains two buttons and the light boxes */
    Pane lightFristRow() {

        /*The MainProgram HBox which has the decremnting button -*/
        HBox pane = new HBox();

        /*The second pane which has the light boxes*/
        HBox lights = new HBox();

        /*The third pane which has the last button to increase the light + */
        HBox pane2 = new HBox();

        pane.setPadding(new Insets(30, 5, 5, 1));
        LightBtn lowBtn = new LightBtn(" - ", 40, 35);
        pane.getChildren().add(lowBtn);

        
        lowBtn.setOnAction(e -> {
            if (rgbCounterRow1 > 0) {
                rgbCounterRow1--;
                Rectangle r = (Rectangle) lights.getChildren().get(rgbCounterRow1);
                r.setFill(Color.rgb(40, 40, 0));
            }

        });

        for (int i = 0; i < 6; i++) {
            Rectangle rect = new Rectangle(45, 25);
            lights.getChildren().add(rect);
            rect.setFill(Color.rgb(40, 40, 0));
        }

        lights.setSpacing(5);
        lights.setPadding(new Insets(5, 0, 5, 0));
        pane.getChildren().add(lights);
        pane.setSpacing(5);
        LightBtn highBtn = new LightBtn(" + ", 40, 35);

        highBtn.setOnAction(e -> {

            if (rgbCounterRow1 < 6) {

                Rectangle r = (Rectangle) lights.getChildren().get(rgbCounterRow1);
                r.setFill(Color.rgb(rgbRedAndGreen[rgbCounterRow1], rgbRedAndGreen[rgbCounterRow1], rgbBlue[rgbCounterRow1]));
                rgbCounterRow1++;

            }

        });
        pane.getChildren().add(pane2);
        pane.getChildren().add(highBtn);
        return pane;
    }

    /*The second Hbox which contains two buttons and the light boxes */
    Pane lightSecondRow() {
        HBox pane = new HBox();
        HBox lights = new HBox();
        HBox pane2 = new HBox();

        pane.setPadding(new Insets(1, 5, 5, 1));
        LightBtn lowBtn = new LightBtn(" - ", 40, 35);
        pane.getChildren().add(lowBtn);

        lowBtn.setOnAction(e -> {

            if (rgbCounterRow2 > 0) {
                rgbCounterRow2--;
                Rectangle r = (Rectangle) lights.getChildren().get(rgbCounterRow2);

                r.setFill(Color.rgb(40, 40, 0));

            }

        });

        for (int i = 0; i < 6; i++) {
            Rectangle rect = new Rectangle(45, 25);
            lights.getChildren().add(rect);
            rect.setFill(Color.rgb(40, 40, 0));
        }

        lights.setSpacing(5);
        lights.setPadding(new Insets(5, 0, 5, 0));
        pane.getChildren().add(lights);
        pane.setSpacing(5);
        LightBtn highBtn = new LightBtn(" + ", 40, 35);

        highBtn.setOnAction(e -> {

            if (rgbCounterRow2 < 6) {

                Rectangle r = (Rectangle) lights.getChildren().get(rgbCounterRow2);
                r.setFill(Color.rgb(rgbRedAndGreen[rgbCounterRow2], rgbRedAndGreen[rgbCounterRow2], rgbBlue[rgbCounterRow2]));
                rgbCounterRow2++;

            }

        });
        pane.getChildren().add(pane2);
        pane.getChildren().add(highBtn);
        return pane;
    }

//    int rgbRed = 40;
//    int rgbGreen = 40;
//    int rgbBlue = 0;
    /*The third Hbox which contains two buttons and the light boxes */
    Pane lightThirdRow() {

        HBox pane = new HBox();
        HBox lights = new HBox();
        HBox pane2 = new HBox();
        pane.setPadding(new Insets(1, 5, 5, 1));
        LightBtn lowBtn = new LightBtn(" - ", 40, 35);

        lowBtn.setOnAction(e -> {

            if (rgbCounterRow3 > 0) {
                rgbCounterRow3--;
                Rectangle r = (Rectangle) lights.getChildren().get(rgbCounterRow3);

                r.setFill(Color.rgb(40, 40, 0));

            }

        });

        pane.getChildren().add(lowBtn);

        for (int i = 0; i < 6; i++) {
            Rectangle rect = new Rectangle(45, 25);
            lights.getChildren().add(rect);
            rect.setFill(Color.rgb(40, 40, 0));
        }

        lights.setSpacing(5);
        lights.setPadding(new Insets(5, 0, 5, 0));
        pane.getChildren().add(lights);
        pane.setSpacing(5);
        LightBtn highBtn = new LightBtn(" + ", 40, 35);

        highBtn.setOnAction(e -> {

            if (rgbCounterRow3 < 6) {

                Rectangle r = (Rectangle) lights.getChildren().get(rgbCounterRow3);
                r.setFill(Color.rgb(rgbRedAndGreen[rgbCounterRow3], rgbRedAndGreen[rgbCounterRow3], rgbBlue[rgbCounterRow3]));
                rgbCounterRow3++;

            }

        });

        pane.getChildren().add(pane2);
        pane.getChildren().add(highBtn);
        return pane;
    }

}
