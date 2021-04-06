/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFX;

import java.io.File;
import java.nio.file.Paths;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Issa
 */
public class PressureControl {

    /* Initialising the borders and the title for the Pressure Control*/
    Pane PressureControl() {

        StackPane pane = new StackPane();
        GridPane grid = new GridPane();
        Label title = new Label("Pressure Control");
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
        pane.setPadding(new Insets(25, 25, 25, 10));
        pane.getChildren().add(ContainerPressure());
        return pane;

    }
    int PressureCounter = 70;
    int MaxPressure = 120;
    int MinPressure = 50;

    /*The container which has all picture, digits, labels and the buttons  */
 /*Each button has a method to increment or decrement*/
    Pane ContainerPressure() {

        VBox pane = new VBox(2);

        /*The first Hbox which contains the picture and labels*/
        HBox container = new HBox();

        container.setSpacing(10);
        String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator + "pressure-icon.png";
        String imgURI = Paths.get(imgPath).toUri().toString();
        ImageView imageView = new ImageView(new Image(imgURI));
        imageView.setFitHeight(60);
        imageView.setFitWidth(60);
        container.getChildren().add(imageView);
        container.setPadding(new Insets(30, 30, 30, 30));

        Label pressureDigit = new Label(Integer.toString(PressureCounter));
        pressureDigit.setTextFill(Color.RED);
        pressureDigit.setStyle("-fx-font: 50 arial;");
        container.getChildren().add(pressureDigit);
        pressureDigit.setPadding(new Insets(1));

        Label C = new Label("kPa");
        C.setTextFill(Color.WHITE);
        C.setStyle("-fx-font: 30 arial;");
        C.setPadding(new Insets(10, 10, 5, 5));
        container.getChildren().add(C);

        /*The second Hbox which contains the buttons*/
        HBox controls = new HBox(2);
        imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator + "up-icon.png";
        imgURI = Paths.get(imgPath).toUri().toString();
        ImageView imageViewUp = new ImageView(new Image(imgURI));
        imageViewUp.setFitHeight(50);
        imageViewUp.setFitWidth(50);
        controls.setPadding(new Insets(0, 0, 0, 90));

        ArrowBtn pressureUp = new ArrowBtn(50, 50);
        pressureUp.setOnAction(e -> {
            if (PressureCounter >= MinPressure && PressureCounter < MaxPressure) {
                PressureCounter += 10;
                pressureDigit.setText(Integer.toString(PressureCounter));
                
            }
        });

        pressureUp.setGraphic(imageViewUp);
        controls.getChildren().add(pressureUp);
        controls.setSpacing(25);
        imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator + "down-icon.png";
        System.out.println(imgPath);
        imgURI = Paths.get(imgPath).toUri().toString();
        ImageView imageViewDown = new ImageView(new Image(imgURI));
        imageViewDown.setFitHeight(50);
        imageViewDown.setFitWidth(50);

        ArrowBtn pressureDown = new ArrowBtn(50, 50);
        pressureDown.setOnAction(e -> {
            if (PressureCounter > MinPressure && PressureCounter <= MaxPressure) {
                PressureCounter -= 10;
                pressureDigit.setText(Integer.toString(PressureCounter));
                
            }
        });
        pressureDown.setGraphic(imageViewDown);
        controls.getChildren().add(pressureDown);
        pane.getChildren().add(container);
        pane.getChildren().add(controls);

        return pane;
    }

}
