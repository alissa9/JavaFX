/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFX;

import java.io.File;
import java.nio.file.Paths;
import java.text.DecimalFormat;
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
public class TemperatureControl {

    /*The main box of the tempretaure which it has two Vboxes to make two rows one that has 
    the picture, digit and unit then the other VBox has the buttons on the second row*/
    Pane Temperature() {
        StackPane pane = new StackPane();

        GridPane grid = new GridPane();
        Label title = new Label("Temperature Control");
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
        pane.setPadding(new Insets(25, 10, 25, 25));

        pane.getChildren().add(ContainerTemp());
        return pane;
    }

    /*Initialising the temperature counter */
    double TempCounter = 20.0;
    double MaxTemp = 27.5;
double MinTemp = 10.0;
    /*To format the output of the tempertaure to a unit and frist decimal place */
    DecimalFormat df = new DecimalFormat("#.#");

    Pane ContainerTemp() {

        VBox pane = new VBox(2);

        HBox container = new HBox();

        /*Printing the temperature image ,the digit and the unit label using the set style methods and padding to place them in the centre of the field */
        container.setSpacing(10);
        String imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator + "thermometer-icon.png";
        String imgURI = Paths.get(imgPath).toUri().toString();
        ImageView imageView = new ImageView(new Image(imgURI));
        imageView.setFitHeight(65);
        imageView.setFitWidth(55);
        container.getChildren().add(imageView);
        container.setPadding(new Insets(30, 30, 30, 30));
        Label tempDigit = new Label(Double.toString(TempCounter));
        tempDigit.setTextFill(Color.RED);
        tempDigit.setStyle("-fx-font: 50 arial;");
        container.getChildren().add(tempDigit);
        tempDigit.setPadding(new Insets(1));

        Label C = new Label("°C");
        C.setTextFill(Color.WHITE);
        C.setStyle("-fx-font: 30 arial;");
        C.setPadding(new Insets(10, 10, 5, 5));
        container.getChildren().add(C);

        /*Adding the container Hbox which it has the picture and labels to the main pane Hbox*/
        pane.getChildren().add(container);

        /*The second HBox which has the arrow up and down button */
        HBox controls = new HBox(2);
        imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator + "up-icon.png";
        imgURI = Paths.get(imgPath).toUri().toString();
        ImageView imageViewUp = new ImageView(new Image(imgURI));
        imageViewUp.setFitHeight(50);
        imageViewUp.setFitWidth(50);

        controls.setPadding(new Insets(0, 0, 0, 90));

        ArrowBtn tempUp = new ArrowBtn(50, 50);
        /*The method for incrementing the temperature 
        which it will increase by 0.1 if the current temp is more than 10 or less that 27.5*/
        tempUp.setOnAction(e -> {

            if (TempCounter >= MinTemp && TempCounter <= MaxTemp) {
                TempCounter += 0.1;
                tempDigit.setText(df.format(TempCounter));

                
            }

        });
        tempUp.setGraphic(imageViewUp);
        controls.getChildren().add(tempUp);
        controls.setSpacing(25);

        imgPath = System.getProperty("user.dir") + File.separator + "images" + File.separator + "down-icon.png";
        imgURI = Paths.get(imgPath).toUri().toString();
        ImageView imageViewDown = new ImageView(new Image(imgURI));
        imageViewDown.setFitHeight(50);
        imageViewDown.setFitWidth(50);
        ArrowBtn tempDown = new ArrowBtn(50, 50);
        tempDown.setGraphic(imageViewDown);

        /*The method for decrementing the temperature which it will subtract 0.1 from the current tempertaure degree */
        tempDown.setOnAction(e -> {

            if (TempCounter > MinTemp && TempCounter < MaxTemp) {
                TempCounter -= 0.1;
                tempDigit.setText(df.format(TempCounter));
            }
        });
        controls.getChildren().add(tempDown);

        /*Adding the controls Hbox which it has the methods buttons to the main pane Hbox*/
        pane.getChildren().add(controls);

        return pane;
    }

}
