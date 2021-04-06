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
public class LightBtn extends Button {

    public LightBtn( String label,double width, double height) {
        super(label);
        this.setMinWidth(width);
        this.setMinHeight(height);
        this.setMaxWidth(width);
        this.setMaxHeight(height);
        this.setPrefWidth(width);
        this.setPrefHeight(height);

//        this.setFont(Font.font("verdana", FontWeight.BOLD, 12));
        this.setStyle("-fx-text-fill: white;" 
                +"-fx-border-color:  white;"
                +"-fx-border-width: 2px;"
                +"-fx-border-radius: 5;"
                +  "-fx-background-color: transparent;"
                + "-fx-cursor: hand;");

    }
}
