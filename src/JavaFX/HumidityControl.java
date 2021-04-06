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
public class HumidityControl {

    /* Initialising the borders and the title for the Humidity Control*/
    Pane HumidityControl() {

        StackPane pane = new StackPane();

        GridPane grid = new GridPane();
        Label title = new Label("Humidity Control");
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

        pane.setPadding(new Insets(25, 5, 25, 5));

        pane.getChildren().add(ContainerHumidity());
        return pane;

    }

    int HumidityCounter = 40;
    int MaxHumidity= 55;
    int MinHumidity=30;

    Pane ContainerHumidity() {

        VBox pane = new VBox(2);

        HBox container = new HBox();
        container.setPadding(new Insets(30, 30, 30, 50));
        /*Printing out the picture, digit and label precentage of the Humidity Control  */
        container.setSpacing(20);
        String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator + "humidity-icon.png";
        String imgURI = Paths.get(imgPath).toUri().toString();
        ImageView imageView = new ImageView(new Image(imgURI));
        imageView.setFitHeight(60);
        imageView.setFitWidth(60);
        container.getChildren().add(imageView);
        
        Label humidityDigit = new Label(Integer.toString(HumidityCounter));
        humidityDigit.setTextFill(Color.RED);
        humidityDigit.setStyle("-fx-font: 50 arial;");
        container.getChildren().add(humidityDigit);

        humidityDigit.setPadding(new Insets(1));

        Label C = new Label("%");
        C.setTextFill(Color.WHITE);
        C.setStyle("-fx-font: 30 arial;");
        C.setPadding(new Insets(10, 5, 5, 5));
        container.getChildren().add(C);
        pane.getChildren().add(container);
        /* The second Hbox which contains the buttons of the Humidity Control*/
        HBox controls = new HBox(2);
        imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator + "up-icon.png";
        imgURI = Paths.get(imgPath).toUri().toString();
        ImageView imageViewUp = new ImageView(new Image(imgURI));
        imageViewUp.setFitHeight(50);
        imageViewUp.setFitWidth(50);

        controls.setPadding(new Insets(0, 0, 0, 90));
        ArrowBtn humidityUp = new ArrowBtn(50, 50);

        humidityUp.setOnAction(e -> {
            if (HumidityCounter >= MinHumidity && HumidityCounter < MaxHumidity) {
                HumidityCounter +=1;
                humidityDigit.setText(Integer.toString(HumidityCounter));
                
            }

        });
        humidityUp.setGraphic(imageViewUp);
        controls.getChildren().add(humidityUp);
        controls.setSpacing(25);

        imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator + "down-icon.png";
        imgURI = Paths.get(imgPath).toUri().toString();
        ImageView imageViewDown = new ImageView(new Image(imgURI));
        imageViewDown.setFitHeight(50);
        imageViewDown.setFitWidth(50);

        ArrowBtn humidityDown = new ArrowBtn(50, 50);
        humidityDown.setOnAction(e -> {
            if (HumidityCounter > MinHumidity && HumidityCounter < MaxHumidity) {
                HumidityCounter -= 1;
                humidityDigit.setText(Integer.toString(HumidityCounter));
                
            }
        });

        humidityDown.setGraphic(imageViewDown);
        controls.getChildren().add(humidityDown);
        pane.getChildren().add(controls);

        return pane;
    }

}
