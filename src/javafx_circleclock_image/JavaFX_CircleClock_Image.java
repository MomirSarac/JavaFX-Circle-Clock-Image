/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_circleclock_image;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Simple example of drawing a clock image in JavaFX.
 * @author Momir Sarac
 */
public class JavaFX_CircleClock_Image extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //create a circle shape
        Circle circleClock = new Circle(150, 150, 100, Paint.valueOf("gray"));
        //create a stack pane
        StackPane root = new StackPane();
        //add circle and text elements to stack pane
        root.getChildren().addAll(circleClock, drawText());
        //create a scene with provided params
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Simple JavaFX Clock Image!");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    /**
     * Draw text elements from 1 to 12 inside a circle
     * @return a group of text elements from 1 to 12
     */
    public strictfp static Group drawText() {
        //a list for storing text numbers
        List<Text> numbersInClock = new ArrayList<>();
        //create a group of shapes
        Group group = new Group();
        //set it to x,y positions
        group.setLayoutX(150);
        group.setLayoutY(150);
        //numbers corresponding to angle calculations
        int[] numbers = {3,4,5,6,7,8,9,10,11,12,1,2};
        double[] angles = {0, 0.166666666667, 0.333333333334,0.5, 0.666666666667, 0.833333333334, 1, 1.166666666667, 1.33333333334, 1.5, 1.666666666667, 1.83333333334};
        int i = 0;
        for (double angle : angles) {    
            //Calculated formula for x,y positions of each number within a circle
            //(x,y) = (rcos(angle),rsin(angle))  
            int r = 90; // length of radius, a bit shorter to put it inside a circle
            //calculate x and y positions based on formula for numbers within a circle
            double x = r * Math.cos(angle*Math.PI);
            double y = r * Math.sin(angle*Math.PI);
            //create a text element consiting a coressponding number
            Text text = new Text(x, y, String.valueOf(numbers[i++]));
            //add it to a list
            numbersInClock.add(text);
        }
        //add all text elements to a group
        group.getChildren().addAll(numbersInClock);
        //return a group
        return group;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
