/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFX;

import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Issa
 */
public class ArrowBtn extends Button {

    public ArrowBtn(double width, double height) {

        this.setMinWidth(width);
        this.setMinHeight(height);
        this.setMaxWidth(width);
        this.setMaxHeight(height);
        this.setPrefWidth(width);
        this.setPrefHeight(height);

        this.setStyle("-fx-background-color: transparent;"
                + "-fx-border-color:  black;"
                + "-fx-border-width: 10px;"
                + "-fx-border-radius: 10;"
                + "-fx-cursor: hand;");

    }
}
