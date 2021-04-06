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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Issa
 */
public class MedicalGases {

    /*Initialising the Medical field with borders and a title*/
    Pane MedicalGases() {
        StackPane pane = new StackPane();
        GridPane grid = new GridPane();
        Label title = new Label("Medical Gases");
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
        pane.getChildren().add(ContainerMedical());
        return pane;
    }

    /*The Medical container which has the Gases labels and boxes */
    Pane ContainerMedical() {
        VBox pane = new VBox();

        pane.setPadding(new Insets(35, 30, 35, 30));
        pane.getChildren().add(HboxGasesFormula());
        pane.setSpacing(2);
        pane.getChildren().add(HboxGasesBoxes());

        return pane;
    }

    /*The labels of the gases titles then styling the color and adding padding to all of them */
    Pane HboxGasesFormula() {
        HBox pane = new HBox();

        Label O2 = new Label("O2");
        Label N20 = new Label("N20");
        Label AIR1 = new Label("AIR1");
        Label CO2 = new Label("CO2");
        Label VAC = new Label("VAC");

        /*An array to style all the gases with a color and font size */
        Label[] LabelArray = {O2, N20, AIR1, CO2, VAC};
        for (Label label : LabelArray) {
            label.setTextFill(Color.YELLOW);
            label.setStyle("-fx-font: 20 arial;");
        }

        pane.setPadding(new Insets(10, 1, 1, 35));
        pane.setSpacing(33);
        pane.getChildren().addAll(O2, N20, AIR1, CO2, VAC);
        return pane;

    }

    /* The boxes of the gases using labels and set style methods to print them */
    Pane HboxGasesBoxes() {

        HBox pane = new HBox();

        /*Initialsing a lebel for each box, Styling each label with a colour and padding */
        Label lowRed = new Label("Low");
        lowRed.setStyle("-fx-background-color: red; -fx-padding: 17px;");

        Label highGreen = new Label("High");
        highGreen.setStyle("-fx-background-color: green; -fx-padding: 17px;");

        Label normGreen = new Label("Norm");
        normGreen.setStyle("-fx-background-color: green; -fx-padding: 17px;");

        Label normRed = new Label("Norm");
        normRed.setStyle("-fx-background-color: red ; -fx-padding: 17px;");

        Label highRed = new Label("High");
        highRed.setStyle("-fx-background-color: red ; -fx-padding: 17px;");

        /*Adding each label to the pane*/
        pane.getChildren().addAll(highGreen, lowRed, normGreen, normRed, highRed);

        /*Adding space betweeen each label by 10px */
        pane.setSpacing(10);
        pane.setPadding(new Insets(0, 0, 20, 20));

        pane.setAlignment(Pos.CENTER);

        return pane;

    }

}
